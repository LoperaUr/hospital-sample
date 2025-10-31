const basePath = globalThis.location.origin; // suponemos misma base que Spring Boot

const $ = (sel) => document.querySelector(sel);

// elementos
const doctorsList = $('#doctors-list');
const refreshDoctorsBtn = $('#refresh-doctors');
const doctorForm = $('#doctor-form');
const messageBox = $('#message');
const resetBtn = $('#reset-form');

// helpers
function showMessage(text, ok = true) {
  messageBox.textContent = text;
  messageBox.style.color = ok ? 'green' : 'crimson';
}

function formatPerson(person) {
  return `${person.firstName} ${person.lastName} (${person.gender ?? ''})`;
}

async function fetchDoctors() {
  doctorsList.innerHTML = '<li>Cargando...</li>';
  try {
    const res = await fetch(`${basePath}/doctor`);
    if (!res.ok) {
      const text = await res.text();
      doctorsList.innerHTML = `<li>Error cargando doctores: HTTP ${res.status} ${text}</li>`;
      return;
    }
    const payload = await res.json();
    // El backend envuelve la respuesta en { message, data }
    const doctorsRaw = payload?.data ?? payload?.body ?? payload;
    let doctors;
    if (Array.isArray(doctorsRaw)) {
      doctors = doctorsRaw;
    } else if (doctorsRaw) {
      doctors = [doctorsRaw];
    } else {
      doctors = [];
    }
    if (doctors.length === 0) {
      doctorsList.innerHTML = '<li>No hay doctores</li>';
      return;
    }
    doctorsList.innerHTML = '';
    for (const d of doctors) {
      const li = document.createElement('li');
      li.textContent = `${d.id ?? ''} - ${formatPerson(d.person)} - ${d.specialty} [${d.licenseNumber}]`;
      doctorsList.appendChild(li);
    }
  } catch (err) {
    doctorsList.innerHTML = `<li>Error cargando doctores: ${err.message}</li>`;
  }
}

function readForm() {
  return {
    person: {
      firstName: $('#firstName').value.trim(),
      lastName: $('#lastName').value.trim(),
      dateOfBirth: $('#dateOfBirth').value || null,
      gender: $('#gender').value || null,
      address: $('#address').value.trim(),
      phoneNumber: $('#phoneNumber').value.trim(),
      email: $('#email').value.trim() || null
    },
    specialty: $('#specialty').value.trim(),
    licenseNumber: $('#licenseNumber').value.trim()
  };
}

async function createDoctor(evt) {
  evt.preventDefault();
  showMessage('Creando doctor...');
  const body = readForm();
  try {
    const res = await fetch(`${basePath}/doctor`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(body)
    });
    const payload = await res.json();
    if (!res.ok) {
      const err = payload?.message || payload?.error || `HTTP ${res.status}`;
      showMessage(`Error creando: ${err}`, false);
      return;
    }
    showMessage('Doctor creado correctamente');
    doctorForm.reset();
    await fetchDoctors();
  } catch (err) {
    showMessage(`Error: ${err.message}`, false);
  }
}

function resetForm() { doctorForm.reset(); messageBox.textContent = ''; }

// eventos
refreshDoctorsBtn.addEventListener('click', fetchDoctors);
doctorForm.addEventListener('submit', createDoctor);
resetBtn.addEventListener('click', resetForm);

// init usando top-level await (script cargado como module)
await fetchDoctors();

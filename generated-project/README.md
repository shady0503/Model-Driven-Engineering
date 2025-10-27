# HealthcareAPI

Generated Spring Boot application using MDE Backend Generator.

## ðŸ“‹ Project Information

- **Group ID**: com.healthcare.system
- **Artifact ID**: HealthcareAPI
- **Version**: 1.0.0
- **Java Version**: 17
- **Spring Boot Version**: 3.2.0
- **Database**: POSTGRESQL

## ðŸ?—ï¸? Generated Entities

### MedicalSpecialties
- **Table**: `medical_specialties`
- **Fields**: 6

### Doctors
- **Table**: `doctors`
- **Fields**: 10
- **Relationships**: 1

### Patients
- **Table**: `patients`
- **Fields**: 13

### Appointments
- **Table**: `appointments`
- **Fields**: 7
- **Relationships**: 2

### MedicalRecords
- **Table**: `medical_records`
- **Fields**: 9
- **Relationships**: 3

### Prescriptions
- **Table**: `prescriptions`
- **Fields**: 11
- **Relationships**: 3


## ðŸš€ Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.8+
- Docker (for database)

### Running the Application

1. **Start the database**:
   ```bash
   docker-compose up -d
   ```

2. **Build the application**:
   ```bash
   mvn clean install
   ```

3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

The API will be available at: `http://localhost:8080`

## ðŸ“š API Endpoints

### MedicalSpecialties

- `POST /api/medical_specialties` - Create new MedicalSpecialties
- `GET /api/medical_specialties` - Get all MedicalSpecialties
- `GET /api/medical_specialties/{id}` - Get MedicalSpecialties by ID
- `PUT /api/medical_specialties/{id}` - Update MedicalSpecialties
- `DELETE /api/medical_specialties/{id}` - Delete MedicalSpecialties

### Doctors

- `POST /api/doctors` - Create new Doctors
- `GET /api/doctors` - Get all Doctors
- `GET /api/doctors/{id}` - Get Doctors by ID
- `PUT /api/doctors/{id}` - Update Doctors
- `DELETE /api/doctors/{id}` - Delete Doctors

### Patients

- `POST /api/patients` - Create new Patients
- `GET /api/patients` - Get all Patients
- `GET /api/patients/{id}` - Get Patients by ID
- `PUT /api/patients/{id}` - Update Patients
- `DELETE /api/patients/{id}` - Delete Patients

### Appointments

- `POST /api/appointments` - Create new Appointments
- `GET /api/appointments` - Get all Appointments
- `GET /api/appointments/{id}` - Get Appointments by ID
- `PUT /api/appointments/{id}` - Update Appointments
- `DELETE /api/appointments/{id}` - Delete Appointments

### MedicalRecords

- `POST /api/medical_records` - Create new MedicalRecords
- `GET /api/medical_records` - Get all MedicalRecords
- `GET /api/medical_records/{id}` - Get MedicalRecords by ID
- `PUT /api/medical_records/{id}` - Update MedicalRecords
- `DELETE /api/medical_records/{id}` - Delete MedicalRecords

### Prescriptions

- `POST /api/prescriptions` - Create new Prescriptions
- `GET /api/prescriptions` - Get all Prescriptions
- `GET /api/prescriptions/{id}` - Get Prescriptions by ID
- `PUT /api/prescriptions/{id}` - Update Prescriptions
- `DELETE /api/prescriptions/{id}` - Delete Prescriptions


## ðŸ§ª Testing

Run tests with:
```bash
mvn test
```

## ðŸ“? License

This is generated code. Add your license information here.

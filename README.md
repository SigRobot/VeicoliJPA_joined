🚗 VeicoliJPA_joined
![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
🌐 Languages / Lingue: 🇬🇧 English | 🇮🇹 Versione Italiana
---
🇬🇧 English Version
📖 Overview
VeicoliJPA_joined is a RESTful backend application built with Spring Boot and Spring Data JPA designed to manage a heterogeneous fleet of vehicles (Cars, Motorcycles, and Bicycles).
The core architectural highlight of this project is the implementation of the JPA `InheritanceType.JOINED` strategy, which maps an object-oriented inheritance hierarchy onto a normalized relational database schema. Shared attributes are stored in a parent `Veicolo` table, while subtype-specific attributes are stored in dedicated tables (`Macchina`, `Moto`, `Bici`) linked via foreign keys.
---
🛠️ Tech Stack
Language: Java
Framework: Spring Boot (Spring Web, Spring Data JPA, Spring Validation)
ORM: Hibernate (Joined Subclass Inheritance Strategy, JPA Specifications)
Build Tool: Apache Maven (with Maven Wrapper included)
Database: Relational SQL Database (configured via `application.properties`, DDL scripts included)
---
🏗️ Project Architecture & Structure
The project follows a clean, multi-layered architecture under the `com.betacom.veicoliJPA_joined` package:
```text
VeicoliJPA_joined/
├── src/main/java/com/betacom/veicoliJPA_joined/
│   ├── controllers/        # REST Controllers & Global Exception Handling
│   ├── dto/
│   │   ├── input/          # Request payloads (*Req) & Validation Groups
│   │   └── output/         # Response payloads (*DTO) & generic ResponseDTO
│   ├── exceptions/         # Custom business exceptions (VeicoloException)
│   ├── mapper/             # Entity <-> DTO conversion utilities (*Map)
│   ├── models/             # JPA Entities, Enums, and Composite Keys
│   ├── repositories/       # Spring Data JPA Repositories
│   ├── services/
│   │   ├── interfaces/     # Business logic contracts
│   │   └── implementations/# Service implementations
│   ├── specifications/     # Dynamic query builders (VeicoloSpecs)
│   └── VeicoliJpaJoinedApplication.java
├── src/main/resources/
│   └── application.properties
├── define.sql              # Database schema creation script
├── drop.sql                # Database schema teardown script
└── pom.xml                 # Maven dependencies and build configuration
```
---
🗄️ Domain Model
Core Inheritance Hierarchy (`JOINED`):
`Veicolo` (Base Entity): Holds common vehicle data and relationships with lookup tables.
`Macchina` (Subclass): Extends `Veicolo` with car-specific attributes (e.g., doors, license plate, engine capacity).
`Moto` (Subclass): Extends `Veicolo` with motorcycle-specific attributes (e.g., license plate, engine cc).
`Bici` (Subclass): Extends `Veicolo` with bicycle-specific attributes using dedicated enums (`Freno`, `Sospensione`, `TipoForcella`).
Lookup / Reference Entities:
`Marca`: Vehicle brand/manufacturer.
`Colore`: Vehicle color.
`Categoria`: Vehicle category/segment.
`Alimentazione`: Fuel/power source type (e.g., Petrol, Diesel, Electric, Manual).
System & Localization Entities:
`Messaggi` & `MessaggiID`: Manages database-driven system and error messages using a composite primary key (`MessaggiID`).
---
✨ Key Features
JPA Joined Inheritance: Clean relational normalization without nullable subtype columns in the parent table.
Dynamic Filtering (JPA Specifications): Complex, multi-criteria vehicle searches implemented via `VeicoloSpecs` and `VeicoloSearchReq`.
DTO & Mapper Pattern: Complete decoupling between internal JPA entities and external API payloads using dedicated Request (`*Req`) and Response (`*DTO`) objects.
Grouped Bean Validation: Contextual input validation (e.g., Create vs. Update operations) powered by `ValidationGroup`.
Centralized Error Handling: Global `@ControllerAdvice` (`ExceptionManager`) catching `VeicoloException` and validation errors to return standardized `ResponseDTO` structures.
Database-Driven Messaging: Dynamic retrieval of error/status messages via `IMessaggioServices`.
---
🚀 Getting Started
Prerequisites
JDK 17 or higher
Maven 3.8+ (or use the included `./mvnw` wrapper)
A running SQL Database instance (MySQL / PostgreSQL / MariaDB depending on your `application.properties`)
Installation & Setup
Clone the repository:
```bash
   git clone <repository-url>
   cd VeicoliJPA_joined-main
   ```
Configure the Database:
Check and update the database connection credentials in `src/main/resources/application.properties`:
```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```
(Optional) You can manually initialize or reset the database schema using the provided SQL scripts:
`define.sql`: Creates tables and constraints.
`drop.sql`: Drops existing tables.
Build the project:
```bash
   ./mvnw clean install
   ```
Run the application:
```bash
   ./mvnw spring-boot:run
   ```
---
🔌 API Controllers Overview
All endpoints return a standardized `ResponseDTO` wrapper. The main controllers exposed are:
Controller	Responsibility
`VeicoloController`	Manages CRUD operations for Vehicles (`Macchina`, `Moto`, `Bici`) and dynamic search queries via `VeicoloSearchReq`.
`BiciController`	Dedicated endpoints for managing bicycle-specific operations.
`MarcaController`	CRUD operations for vehicle brands (`Marca`).
`CategoriaController`	CRUD operations for vehicle categories (`Categoria`).
`ColoreController`	CRUD operations for vehicle colors (`Colore`).
`AlimentazioneController`	CRUD operations for fuel/power types (`Alimentazione`).
---
---
🇮🇹 Versione Italiana
📖 Panoramica del Progetto
VeicoliJPA_joined è un'applicazione backend RESTful sviluppata con Spring Boot e Spring Data JPA, progettata per la gestione completa di un parco veicoli eterogeneo (Macchine, Moto e Biciclette).
Il punto di forza architetturale del progetto è l'utilizzo della strategia di ereditarietà `InheritanceType.JOINED` di JPA, che permette di mappare una gerarchia di classi orientata agli oggetti su uno schema di database relazionale normalizzato. Gli attributi comuni sono salvati nella tabella padre `Veicolo`, mentre gli attributi specifici di ogni sottotipo risiedono in tabelle dedicate (`Macchina`, `Moto`, `Bici`) collegate tramite chiavi esterne.
---
🛠️ Tecnologie Utilizzate
Linguaggio: Java
Framework: Spring Boot (Spring Web, Spring Data JPA, Spring Validation)
ORM: Hibernate (Strategia di ereditarietà Joined, JPA Specifications)
Build Tool: Apache Maven (con Maven Wrapper incluso)
Database: Database SQL Relazionale (configurato tramite `application.properties`, script DDL inclusi)
---
🏗️ Architettura e Struttura del Progetto
Il progetto adotta un'architettura stratificata (Layered Architecture) all'interno del package `com.betacom.veicoliJPA_joined`:
```text
VeicoliJPA_joined/
├── src/main/java/com/betacom/veicoliJPA_joined/
│   ├── controllers/        # Controller REST e gestione centralizzata delle eccezioni
│   ├── dto/
│   │   ├── input/          # Payload di richiesta (*Req) e gruppi di validazione
│   │   └── output/         # Payload di risposta (*DTO) e wrapper ResponseDTO
│   ├── exceptions/         # Eccezioni custom di dominio (VeicoloException)
│   ├── mapper/             # Classi di conversione Entity <-> DTO (*Map)
│   ├── models/             # Entità JPA, Enum e Chiavi Composte
│   ├── repositories/       # Interfacce Spring Data JPA Repository
│   ├── services/
│   │   ├── interfaces/     # Interfacce dei servizi di business
│   │   └── implementations/# Implementazioni della logica di business
│   ├── specifications/     # Costruttori di query dinamiche (VeicoloSpecs)
│   └── VeicoliJpaJoinedApplication.java
├── src/main/resources/
│   └── application.properties
├── define.sql              # Script SQL per la creazione dello schema
├── drop.sql                # Script SQL per la rimozione delle tabelle
└── pom.xml                 # Configurazione Maven e dipendenze
```
---
🗄️ Modello dei Dati (Domain Model)
Gerarchia Principale (`JOINED`):
`Veicolo` (Entità Base): Contiene i dati comuni a tutti i veicoli e le relazioni verso le tabelle tipologiche.
`Macchina` (Sottoclasse): Estende `Veicolo` con attributi specifici per le automobili (es. numero porte, targa, cilindrata).
`Moto` (Sottoclasse): Estende `Veicolo` con attributi specifici per i motocicli (es. targa, cilindrata).
`Bici` (Sottoclasse): Estende `Veicolo` con attributi specifici per le biciclette, supportati da appositi Enum (`Freno`, `Sospensione`, `TipoForcella`).
Entità Tipologiche (Lookup):
`Marca`: Produttore/marchio del veicolo.
`Colore`: Colore del veicolo.
`Categoria`: Categoria o segmento del veicolo.
`Alimentazione`: Tipo di alimentazione (es. Benzina, Diesel, Elettrica, Muscolare).
Entità di Sistema e Messaggistica:
`Messaggi` & `MessaggiID`: Gestisce i messaggi di sistema e di errore salvati a database tramite una chiave primaria composta (`MessaggiID`).
---
✨ Funzionalità Principali
Ereditarietà JPA Joined: Garantisce uno schema relazionale pulito e normalizzato, evitando colonne `NULL` superflue nella tabella principale.
Ricerca Dinamica (JPA Specifications): Filtri di ricerca avanzati e combinabili sui veicoli implementati tramite `VeicoloSpecs` e `VeicoloSearchReq`.
Pattern DTO & Mapper: Disaccoppiamento totale tra le entità di persistenza e i contratti esposti dalle API tramite oggetti di input (`*Req`) e output (`*DTO`).
Validazione a Gruppi: Validazione contestuale dei dati in ingresso (es. distinzione tra creazione e modifica) tramite l'interfaccia `ValidationGroup`.
Gestione Centralizzata delle Eccezioni: Componente `ExceptionManager` per intercettare `VeicoloException` ed errori di validazione, restituendo risposte uniformi tramite `ResponseDTO`.
Messaggi Dinamici su DB: Recupero centralizzato dei messaggi d'errore e di sistema tramite `IMessaggioServices`.
---
🚀 Installazione e Avvio
Prerequisiti
JDK 17 o superiore
Maven 3.8+ (oppure utilizzo del wrapper `./mvnw` integrato)
Un'istanza di Database SQL attiva (MySQL / PostgreSQL / MariaDB in base alla configurazione)
Procedura di Configurazione
Clona il repository:
```bash
   git clone <url-del-repository>
   cd VeicoliJPA_joined-main
   ```
Configura il Database:
Verifica e aggiorna i parametri di connessione nel file `src/main/resources/application.properties`:
```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/nome_database
   spring.datasource.username=tuo_utente
   spring.datasource.password=tua_password
   ```
(Opzionale) È possibile creare o eliminare manualmente le tabelle eseguendo gli script SQL presenti nella root del progetto:
`define.sql`: Genera le tabelle e le relazioni.
`drop.sql`: Elimina le tabelle dal database.
Compila il progetto:
```bash
   ./mvnw clean install
   ```
Avvia l'applicazione:
```bash
   ./mvnw spring-boot:run
   ```
---
🔌 Panoramica dei Controller API
Tutti gli endpoint restituiscono i dati incapsulati nell'oggetto standard `ResponseDTO`. I controller principali sono:
Controller	Responsabilità
`VeicoloController`	Gestisce le operazioni CRUD sui veicoli (`Macchina`, `Moto`, `Bici`) e le ricerche filtrate dinamiche tramite `VeicoloSearchReq`.
`BiciController`	Endpoint dedicati alle operazioni specifiche sulle biciclette.
`MarcaController`	Operazioni CRUD per la gestione delle marche (`Marca`).
`CategoriaController`	Operazioni CRUD per la gestione delle categorie (`Categoria`).
`ColoreController`	Operazioni CRUD per la gestione dei colori (`Colore`).
`AlimentazioneController`	Operazioni CRUD per la gestione dei tipi di alimentazione (`Alimentazione`).

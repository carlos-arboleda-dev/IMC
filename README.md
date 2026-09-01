# 📱 Calculadora de Índice de Masa Corporal (IMC)

Aplicación móvil nativa desarrollada en Android Studio con Kotlin para la gestión y cálculo del Índice de Masa Corporal (IMC). La aplicación implementa arquitectura multicapa mediante el uso de múltiples `Activities`, transmisión de datos serializados y un historial persistente en memoria.

---

## 🚀 Características Principales

* **Cálculo de IMC en Tiempo Real:** Procesa peso (kg) y estatura (cm) para determinar el estado de salud del usuario con base en rangos estándar.
* **Resultados Dinámicos:** Muestra la clasificación de salud acompañada de recursos visuales e identificadores correspondientes.
* **Historial de Mediciones:** Registro cronológico estructurado de mediciones con fecha, hora y datos métricos detallados.
* **Internacionalización (i18n):** Soporte multiidioma dinámico (Español e Inglés) gestionado mediante recursos nativos (`strings.xml`).
* **Soporte de Tema Dinámico:** Alternancia entre Modo Oscuro y Modo Claro mediante `AppCompatDelegate`.
* **Splash Screen API:** Pantalla de bienvenida oficial mediante `androidx.core:core-splashscreen`.

---

## 🛠️ Tecnologías y Arquitectura

* **Lenguaje:** Kotlin
* **IDE:** Android Studio
* **Componentes UI:** Views XML con **View Binding**
* **Patrones de Diseño:** Singleton (`HistoryManager`)
* **Transferencia de Datos:** `Intent` con objetos `Serializable`
* **Manejo de Estilos:** Material Design 3 (`Material3.DayNight`)

---

## 📂 Estructura del Proyecto

```text
app/src/main/java/com/example/imc/
│
├── Measurement.kt       # Modelo de datos (Serializable) y Singleton de historial
├── MainActivity.kt      # Pantalla principal (Formulario, Cálculo, Tema)
├── ResultActivity.kt    # Visualización del resultado e imagen asignada
└── HistoryActivity.kt   # Presentación del historial de registros
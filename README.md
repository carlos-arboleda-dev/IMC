# 📱 Calculadora de Índice de Masa Corporal (IMC)

Aplicación móvil nativa desarrollada en Android Studio con Kotlin para la gestión y cálculo del Índice de Masa Corporal (IMC). La aplicación implementa arquitectura multicapa mediante el uso de múltiples `Activities`, transmisión de datos serializados y un historial persistente en memoria.

---

## 📄 Descripción Funcional

La aplicación está diseñada bajo una arquitectura Android multi-pantalla (`Multi-Activity`) orientada al flujo continuo de usuario:

* **Módulo de Entrada y Cálculo:** Captura el peso ($kg$) y la estatura ($cm$) del usuario, realiza la conversión métrica e implementa el cálculo del IMC. Determina dinámicamente la clasificación del usuario (Bajo peso, Peso normal, Sobrepeso, Obesidad).
* **Módulo de Diagnóstico e Imagen:** Presenta la evaluación antropométrica final junto con indicadores gráficos específicos para cada rango de salud y opciones de retorno seguro al menú principal.
* **Módulo de Historial Persistente:** Mantiene una bitácora en memoria de todas las evaluaciones ejecutadas en la sesión. Cada registro almacena fecha, hora, peso, estatura, IMC obtenido y diagnóstico asociado, ordenados cronológicamente.
* **Internacionalización y Soporta Multi-idioma:** Gestión completa de recursos de texto para soporte dinámico en Español e Inglés mediante recursos nativos (`strings.xml`).
* **Gestión de Tema Visual:** Botón de alternancia global entre Modo Claro y Modo Oscuro mediante la API `AppCompatDelegate`.
* **Splash Screen Nativo:** Pantalla de bienvenida oficial configurada desde temas del sistema mediante la librería `androidx.core:core-splashscreen`.

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

---

👤 Autor

Carlos Cesar Arboleda — Desarrollador Principal

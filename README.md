# One challenge: Conversor de Monedas 🪙💱

Aplicación Java que obtiene de una API la conversión de moneda actual de distintos países.

---
 ## 📄 Descripción del proyecto

Esto proyecto forma parte del programa Oracle Next Education propuesto por Oracle en colaboración con Alura Latam.
Es una aplicación Java que permite realizar conversiones de divisas en tiempo real. Utiliza la API de **ExchangeRate-API** para obetener tas de cambio actualizadas y ofrece una interfaz interactiva para el usuario a través de la consola. 

El objetivo principal fue aplicar conceptos avanzados de Programación Orientada a Objetos, consumo de APIs, manejo de archivos JSON y control de excepciones robusto.

## 🛠️ Tecnologías Utilizadas
- **Java (JDK 17+):** Lenguaje principal. Uso de características modernas como Records y HttpClient.

- **Gson (Google):** Librería para la deserialización de datos JSON a objetos Java.

- **ExchangeRate-API:** Servicio externo para consultar valores de divisas.

- **IntelliJ IDEA:** Entorno de desarrollo integrado (IDE).

## ✨ Características Principales

1. **Consumo de API en Tiempo Real:** Conexión HTTP para obtener datos actualizados.


2. **Historial de Conversiones:** Almacenamiento en memoria (ArrayList) de las consultas realizadas durante la sesión.


3. **Manejo de Errores Robusto:**

   - Validación de entradas numéricas para evitar errores de texto (InputMismatchException).
   - Control de errores de la API (monedas inexistentes).


4. **Modelado de Datos:** Uso de una clase intermedia (ConversionModel) para presentar un ticket detallado con el monto original y el resultado.


5. **Seguridad:** Uso de variables de entorno para proteger la API KEY.

## 🌎 Monedas Soportadas 
El sistema permite ingresar códigos ISO (ej. USD, MXN), pero cuenta con un menú de referencia para las siguientes:

🇺🇸 USD - Dólar Estadounidense

🇲🇽 MXN - Peso Mexicano

🇦🇷 ARS - Peso Argentino

🇧🇷 BRL - Real Brasileño

🇨🇴 COP - Peso Colombiano

🇪🇺 EUR - Euro

... Entre otras que la API soporta de manera estandarizada.

## ⚙️ Cómo Usar / Instalación

### Prerrequisitos

1. Tener instalado Java JDK 17 o superior.


2. Obtener una API Key gratuita en ExchangeRate-API.

### Pasos

1. **Clonar el repositorio**

``` bash 
git clone git@github.com:JulianBcb07/conversor-de-monedas.git
```

2. **Configurar la API Key:**

   - El proyecto utiliza variables de entorno para seguridad.

   - En IntelliJ IDEA: Ve a Run > Edit Configurations.

   - En "Environment variables", agrega: API_KEY=tu_clave_aqui.

   - (Si usas terminal, exporta la variable según tu sistema operativo).


3. **Ejecutar**:

   - Corre la clase Main.java desde tu IDE.

## 📂 Estructura del Proyecto
El código está organizado bajo el principio de separación de responsabilidades:

```
com.project.conversormonedas
│
├── api
│   └── ApiRequest.java       # Maneja la conexión HTTP y la petición a la API.
│ 
├── main
│   └── Main.java             # Punto de entrada. Maneja el menú y la interacción con el usuario.
│
└── models
    ├── Moneda.java           # Record (DTO) que mapea la respuesta JSON exacta de la API.
    └── ConversionModel.java  # Clase de dominio que combina los datos de la API + Input del usuario para el historial.
```



---

<h4 align="center">
👨‍💻 Autor Julian Bacab – [@JulianBcb07](https://github.com/JulianBcb07)
</h4>
<h4 align="center">
🚀 Link del proyecto - https://github.com/JulianBcb07/conversor-de-monedas.git
</h4>

---
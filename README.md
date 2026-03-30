# Mobile Automation Final Project - Appium & TestNG

Este proyecto contiene una suite de pruebas automatizadas para la aplicación nativa de Android WDIO Demo App, desarrollada como parte del proceso de consolidación en automatización móvil. Se utiliza el patrón de diseño Page Object Model (POM) con Fluent Interface, garantizando independencia, robustez e idempotencia en cada escenario.

---
# 🚀 Tecnologías Utilizadas
* Lenguaje: Java 17
* Framework de Pruebas: TestNG 
* Herramienta de Automatización: Appium (UIAutomator2 Driver)
* Gestor de Dependencias: Maven 
* Librerías Adicionales: 
  * Java Faker: Para la generación de datos aleatorios (Emails/Passwords). 
  * Selenium Java: Para interacciones avanzadas de W3C Actions.
---
# 🛠️ Requisitos Previos
Antes de ejecutar los tests, asegúrate de tener instalado:
* Java JDK 17 o superior. 
* Android Studio (con un Emulador configurado, preferiblemente Android 11+). 
* Appium Server 2.x instalado mediante NPM (npm install -g appium). 
* UIAutomator2 Driver (appium driver install uiautomator2). 
* Maven configurado en las variables de entorno.
---
# 📁 Arquitectura del Proyecto
El proyecto sigue una estructura de Page Object Model (POM):
* src/main/java/com/globant/mobile/screens: Contiene las clases de las pantallas (Locators y Acciones). 
* src/main/java/com/globant/mobile/utils: Clases auxiliares como DataGenerator (usando Faker). 
* src/test/java/com/globant/mobile/tests: Clases de prueba divididas por lógica de negocio (LoginTest, SwipeTest, etc.). 
* src/test/resources/testng.xml: Archivo de configuración para la ejecución en suite.
---
# 🧪 Escenarios Automatizados
1. **Navegación (Bottom Navigation Bar)**
   Verifica que todos los iconos de la barra inferior (Home, Webview, Login, Forms, Swipe, Drag) redirijan a sus secciones correspondientes y que los elementos clave sean visibles.
2. **Registro Exitoso (Sign Up)**
   Utiliza datos dinámicos únicos para cada ejecución. Valida la aparición de la alerta nativa de Android al completar el registro.
3. **Inicio de Sesión (Successful Login)**
   Implementa una precondición dinámica: crea un usuario nuevo mediante el flujo de Sign Up antes de intentar el Login, asegurando que el test sea idempotente e independiente de ejecuciones previas.
4. **Interacción con Tarjetas (Swipe Cards)**
   Implementa gestos complejos de W3C Actions:

   * Swipe Horizontal: Desplazamiento entre tarjetas verificando la transición mediante IDs dinámicos (__CAROUSEL_ITEM_X__). 
   * Scroll Vertical: Búsqueda del texto oculto "You found me!!!" mediante desplazamientos verticales controlados.
---
# ⚙️ Configuración y Ejecución
1. **Clonar el repositorio:**


>git clone https://github.com/Juan-Porras-15/Mobile_Testing_Final_Project

>cd Mobile_Testing_Final_Project


2. **Iniciar el servidor de Appium:**


>appium

3. Configurar el Emulador:
Asegúrate de que el deviceName en tu clase BaseTest coincida con el nombre de tu emulador en Android Studio.
Puedes verificar el nombre de devide usando:

>adb devices


4. Ejecutar los tests mediante Maven:

>mvn test

---
# 💡 Mejores Prácticas Aplicadas
* **Esperas Explícitas:** No se utilizan Thread.sleep(). Todas las interacciones esperan a que el elemento sea visible o clickeable. 
* **Gestos Robustos:** El método de Swipe incluye una pausa de presión inicial (PointerDown) para asegurar que el sistema operativo registre el inicio del arrastre, evitando "flakiness". 
* **Fluent Interface:** Los métodos de navegación en las Screens devuelven la instancia de la siguiente pantalla para facilitar la escritura de tests limpios. 
* **Independencia de Tests:** Cada clase de prueba limpia su estado y puede ejecutarse de forma aislada.

---
**Desarrollado por:** Juan Andrés Porras Vélez

**Organización:** Globant - TAE Training - Mobile Automation Course - 2026
# Conversor Divisas


![Portada del Proyecto](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFV75-TfbePIknuC7TSnpPEwNZLDHAnWY66g&s) 


![GitHub release (latest by date)](https://img.shields.io/github/v/release/usuario/conversor-de-monedas)
![GitHub release (last Commit)](https://img.shields.io/badge/last_commit-22%2F09%2F2024-brightgreen)
![GitHub issues](https://img.shields.io/github/issues/usuario/conversor-de-monedas)


## Índice

- [Descripción del Proyecto](#descripción-del-proyecto)
- [Estado del Proyecto](#estado-del-proyecto)
- [Demostración de Funciones y Aplicaciones](#demostración-de-funciones-y-aplicaciones)
- [Acceso al Proyecto](#acceso-al-proyecto)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Personas Contribuyentes](#personas-contribuyentes)
- [Personas Desarrolladoras del Proyecto](#personas-desarrolladoras-del-proyecto)
- [Licencia](#licencia)

## Descripción del Proyecto

**Conversor de Monedas** es una aplicación diseñada para facilitar la consulta y conversión de divisas en tiempo real. Utiliza la API de ExchangeRate para obtener tasas de cambio precisas y actualizadas. El proyecto está enfocado en ayudar a usuarios que necesitan acceso rápido y fácil a las tasas de cambio de varias monedas.

### Versiones del Proyecto

Este proyecto cuenta con tres versiones principales, cada una ofreciendo características distintas:

- **VAlura**: 
  En esta versión, se utilizan las conversiones recomendadas por la plataforma educativa ALURA, calculadas a partir del dólar estadounidense (USD) hacia otras monedas (BRL, ARS, MXN, COP) y biceversa. Solo se permite la conversión entre estas divisas, y se puede acceder a un historial de transacciones que muestra los registros de las conversiones realizadas y la fecha de las mismas.

- **VArturo 1.0**: 
  Esta versión permite la conversión entre pares de divisas directamente desde la API de ExchangeRate. Aunque se sigue enfocando en las mismas monedas (USD, BRL, ARS, MXN, COP), el proceso de conversión es más sencillo. También se puede acceder al historial de transacciones para visualizar las operaciones realizadas.

- **VArturo 2.0**: 
  La versión más avanzada del proyecto, VArturo 2.0, amplía el acceso a cualquier par de divisas disponibles en la API. Ofrece una función de autocompletado primitiva: al escribir la primera letra de una moneda, se sugieren todas las opciones que coincidan, ayudando al usuario a seleccionar la moneda correcta. Además, cuenta con un archivo de ayuda que proporciona información sobre qué moneda corresponde a cada país. Como en las versiones anteriores, se puede acceder al historial de transacciones.

Todas las versiones permiten navegar entre ellas y finalizar el programa desde cualquier punto.

## Estado del Proyecto

![Estado del Proyecto](https://img.shields.io/badge/estado-terminado-brightgreen)

El proyecto está completamente desarrollado. Todas las funcionalidades principales están implementadas, y el sistema de conversión de divisas funciona de manera estable. Las versiones VAlura, VArturo 1.0 y VArturo 2.0 están listas para su uso con todas las características descritas.

## Demostración de Funciones y Aplicaciones

A continuación se presentan algunas de las funciones clave de **Conversor de Monedas**:

- **Tasas de cambio en tiempo real**: Obtén conversiones de divisas actualizadas directamente desde la API de ExchangeRate.
- **Historial de transacciones**: Accede a los registros de todas las conversiones realizadas, con detalles sobre la fecha y las monedas utilizadas.
- **Autocompletado (VArturo 2.0)**: Ingresa las primeras letras de una moneda para recibir sugerencias de pares de divisas.
- **Navegación entre versiones**: Cambia entre las versiones del proyecto (VAlura, VArturo 1.0, VArturo 2.0) y finaliza el programa desde cualquier versión.

- **A continuación un video ejemplo**: Se prueban todas las funcionalidades y validaciones de errores.
[![Nombre del Video](https://img.freepik.com/vector-gratis/diseno-maqueta-plantilla-reproductor-video-negro_1017-36895.jpg)](https://drive.google.com/file/d/18zi14s_RE2UHQNbUgZDwemAKWrKl16N3/view?usp=sharing)

## Acceso al Proyecto


Para clonar este proyecto localmente, utiliza el siguiente comando:

```bash
git clone https://github.com/arturohdezc/conversormonedas.git

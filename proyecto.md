# Proyecto

## El problema

Es común realizar múltiples tareas durante el día. Muchos recurrimos a la memoria para llevar la cuenta de todas esas cosas por hacer (*TODO*). Sin embargo, resulta de gran utilidad llevar un registro con todas las cosas por hacer e ir marcando éstas conforme han sido realizadas.

Para llevar este tipo de control, las aplicaciones que gestionan "listas de cosas por hacer" (*TODO list*) son comúnmente utilizadas.

## El proyecto

Desarrollar una aplicación para la gestión de cosas por hacer, en tres entregas, a saber:

1. **Requerimientos y mockups**. *Backlog* del producto con historias de usuario y sus criterios de aceptación. Además, prototipo no funcional de baja fidelidad.
1. **Backend y maquetación**. *Backend* (API Rest) de la aplicación y HTML de la Interfaz Gráfica. La API deberá seguir el estándar acordado por el curso.
1. **Entrega final**. Aplicación funcional acompañado de Dockerfile para el despliegue automático en Docker.

## Consideraciones funcionales

La aplicación deberá:
- Administrar una lista de cosas por hacer
- Permitir marcar las cosas por hacer como finalizadas
- Ver todas las cosas por hacer (pendientes o realizadas) y sólo las pendientes
- Mantener la lista de cosas por hacer aún habiendo reiniciado el servidor

## Consideraciones no funcionales

- La aplicación deberá contar con un *backend* (API Rest) y un *frontend* utilizando Javascript + HTML o una app para Android o iOS
- El *frontend* deberá comunicarse con el *backend* vía AJAX
- El código debe tener -al menos- pruebas: unitarias y de integración

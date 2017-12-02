# API Rest

## Listar TODOs

GET /v1/todos?lista=x

Respuesta:
- 200: 
	- BODY:
		```
		[
			{
				id: x,
				nombre: x,
				descripcion: x,
				completada: true | false,
				fecha: x
			}, ...
		]
		```
- 500: Error en el servidor
	- BODY: `{ mensaje: "..." }`

## Eliminar TODO

DELETE /v1/todos/:id

Respuesta:
- 200: Eliminado
- 404: TODO no encontrado
- 500: Error en el servidor
	- BODY: `{ mensaje: "..." }`

## Alterar (*toggle*) TODO

PUT /v1/todos/:id/alterar-completado

Respuesta:
- 200: Alterado
- 404: TODO no entontrado
- 500: Error en el servidor
	- BODY: `{ mensaje: "..." }`

## Modificar TODO

PUT /v1/todos/:id

Body:
```
{
	nombre: x,
	descripcion: x,
	completada: true | false,
}
```

Respuesta:
- 200: Modificado
- 404: TODO no entontrado
- 500: Error en el servidor
	- BODY: `{ mensaje: "..." }`

## Agregar TODO

POST /v1/todos

Body:
```
{
	nombre: x,
	descripcion: x,
}
```

Respuesta:
- 200: Agregado
	- BODY: `{ id: x }`
- 500: Error en el servidor
	- BODY: `{ mensaje: "..." }`


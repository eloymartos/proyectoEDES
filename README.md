# Proyecto Final 2º Trimestre
---
 Eloy Martos y José Manuel Luque
---

![alt text](https://www.kissfm.es/wp-content/uploads/2022/06/pokemon.jpg)

---

**Perfil Github Eloy: <https://github.com/eloymartos> <br>**
**Perfil Github Josema: <https://github.com/JoseManuelLuque>**

Documento de refactorizacion = <a href="https://github.com/eloymartos/proyectoEDES/blob/cd8613e5be796fe723af45421d7682644e93d410/refactorizacion.pdf">enlace</a>

# Resumen del proyecto

### Clase Tipo
` Esta es la base de Pokemon y Ataque, contiene todos los posibles tipos y las efectividades de estos, aparte del tipo en concreto `
<hr>

` tiene la funcion efectividad que segun la efectividad de un movimiento respecto a nuestro tipo, devuelve un multiplicador `

### Clase Ataque
` Esta hereda de Tipo y aparte, contiene Nombre y Potencia `

### Clase Pokemon
` Esta hereda de Tipo y aparte, contiene Nombre, Lore, Vida y Ataques, siendo este ultimo una lista de ataques `
<hr>

`Tiene varias funciones :` <br>
`Recibir ataque, resta a la vida la potencia por efectividad de un ataque, segun el resultado da una cadena u otra, siendo la diferencia que la vida sea menor o igual que 0 ` <br>
`Asignar ataques, de forma aleatoria saca ataques de una lista y si son comparibles con nuestro tipo, los guardamos, hasta un maximo de 4` <br>
` Mostrar ataques, muestra los ataques con sus atributos ` <br>
`Atacar, que recibe el nombre del ataque a devolver ` <br>
`AtacarIA, que devuelve un ataque random para que use la IA ` 

### Clase Entrenador
`Esta es independiente, tiene un array de 3 pokemon`
### Clase Main

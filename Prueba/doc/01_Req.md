# Requisitos del Sistema – Caso de Estudio E

## REQ01 – Autenticación
El sistema debe solicitar autenticación al iniciar mediante usuario y contraseña.  
Debe existir el usuario patmic con contraseña 123, permitiendo máximo 3 intentos.  
Si la autenticación es válida, el sistema debe solicitar número de cédula y nombre completo del entomólogo.

## REQ02 – Cosecha de datos (ETL)
El entomólogo debe cosechar, según su caso de estudio E, datos de hormigas y alimentos desde el storage mediante un proceso ETL (Extract, Transform, Load).

Durante el proceso:
- Se debe mostrar Loading / Waiting por cada dato.
- Los datos válidos se muestran en color azul y se almacenan solo si corresponden al caso de estudio.
- Los datos con error se muestran en color rojo.

Los archivos de origen son:
- storage/DataFiles/AntNest.txt
- storage/DataFiles/AntFood.txt

## REQ03 – Tipo de hormiga del caso E
La KGD requiere crear TIPO_HORMIGA que derive de Hormiga.  
Toda hormiga nace como HLarva.

- HLarva vive si come Néctar.
- Si HLarva come su alimento correspondiente, se transforma en su TIPO_HORMIGA.
- El TIPO_HORMIGA vive únicamente si come su ALIMENTO.

Caso de estudio E (cédula terminada en 5):

| TIPO_HORMIGA   | ALIMENTO (VIVE) |
|---------------|-----------------|
| HLarva        | Néctar          |
| HObrera       | Herbívoro       |

## REQ04 – Genoma
Las hormigas deben manejar genomas X, XX y XY, los cuales determinan el sexo de la hormiga y su correspondencia con el caso de estudio E.

## REQ05 – Superhabilidad
Cuando el genoma de la hormiga corresponde al caso de estudio E, se debe habilitar la superHabilidad:
- superRastrear()

La hormiga debe tener una propiedad asociada a su superHabilidad.

## REQ06 – Preparación de alimento
La acción preparar(Alimento) debe ser realizada únicamente por el entomólogo o el entomólogo genetista.

- El entomólogo genetista prepara el alimento inyectando un genoma aleatorio (X, XX, XY) e imprime:
  Preparado – [tipoAlimento + Genoma]
- El entomólogo prepara el alimento sin genoma e imprime:
  Preparado – [tipoAlimento]

## REQ07 – Vida y muerte de la hormiga
La hormiga vive si come su alimento correcto acorde a su genoma; caso contrario, la hormiga muere.  
El alimento consumido debe ser eliminado.

## REQ08 – Interfaz Entomólogo
Se debe implementar la interfaz IEntomologo con las siguientes operaciones:
- eatAntNest() : List<Hormiga>
- eatAntFood() : List<Alimento>
- alimentarAnt(Hormiga, Alimento) : Hormiga

## REQ09 – Arquitectura
El proyecto debe implementar la siguiente estructura arquitectónica:

App  
- ConsoleApp  
- BusinessLogic  
- DataAccess  
- Infrastructure

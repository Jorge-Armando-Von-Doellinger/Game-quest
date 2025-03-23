```mermaid
classDiagram
    class GameModel {
        -String name
        -GameStatus status
    }

    class Game {
        +Long Id
        +String name
        +GameStatus status
        +Date createdAt
        +Date updatedAt
    }

classDiagram
    class Game {
        +Long Id
        +String name
        +GameStatus status
        +Date createdAt
        +Date updatedAt
    }
    
    class GameModel {
        +String name
        +GameStatus status
    }

    class GameStatus {
        <<enumeration>>
    }

    GameModel --> GameStatus
    Game --> GameStatus

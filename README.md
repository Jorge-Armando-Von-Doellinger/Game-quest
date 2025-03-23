classDiagram
    direction TB
    
    class Game {
        + Long Id
        + String name
        + GameStatus status
        + Date createdAt
        + Date updatedAt
    }
    
    class GameModel {
        + String name
        + GameStatus status
    }

    class GameStatus {
        <<enumeration>>
        + ACTIVE
        + INACTIVE
        + PENDING
    }

    %% Relacionamentos
    GameModel --> GameStatus : "Usa"
    Game --> GameStatus : "Possui"

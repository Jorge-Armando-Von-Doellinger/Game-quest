classDiagram
    direction TB

    class User {
        - String name
        - Account account
        - Feature[] features
        - Card card
        - News[] news
    }

    class Account {
        - String number
        - String agency
        - Number balance
        - Number limit
    }

    class Feature {
        - String icon
        - String description
    }

    class Card {
        - String number
        - Number limit
    }

    class News {
        - String icon
        - String description
    }

    %% Relacionamentos
    User "1" *-- "1" Account : "Possui"
    User "1" *-- "N" Feature : "Tem"
    User "1" *-- "1" Card : "Usa"
    User "1" *-- "N" News : "Recebe"

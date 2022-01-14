##Bubble Shooter Game
This game is a project for Design Patterns 2021/2022 university course.
The aim was to implement 8 different design patterns.

Some of these patterns are not necessary, as the game is unlikely to be developed and extended further.

##Design Patterns
1. Singleton - e.g. in Player class, makes sure that there is only one instance of Player class available at any time.
2. Factory Method - BubbleFactory, Bubble, BubbleNormal, BubbleBomb, BubbleMulticolor, deals with the problem of creating Bubble objects with different properties.
3. State - ScreenState, GameScreenState, SettingsScreenState, MenuScreenState, allows to change the current shown screen.
4. Template Method - ScreenSetup, defines the skeleton of setting up any of the three available screens.
5. Observer - CollisionDetector, Breaker, notifies the class responsible for breaking bubbles about a collision between bubbles on the same color.
6. Strategy - Breaker, SearchStrategy, BFSStrategy, enables selecting an algorithm for searching the bubble graph
7. TODO
8. TODO
9. TODO extra
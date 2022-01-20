## Bubble Shooter Game
This game is a project for Design Patterns 2021/2022 university course.
The aim was to implement 8 different design patterns.

Some of these patterns are not necessary, as the game is unlikely to be developed and extended further, but they have been used in order to practise writing them.

## Design Patterns
| ID | Name | Functionality |
| :--- | :--- | :--- |
| 1. | Singleton | e.g. in GameLogic class, makes sure that there is only one instance of this class available at any time |
| 2. | Factory Method | deals with the problem of creating Bubble objects with different properties |
| 3. | State | allows to change the current shown screen |
| 4. | Template Method | defines the skeleton of setting up any of the three available screens |
| 5. | Observer | notifies the class responsible for breaking bubbles about a collision between bubbles on the same color |
| 6. | Strategy | enables selecting an algorithm for searching the bubble graph | 
| 7. | Command | allows switching between left/right arrows and A/D keys to move the shooter aim | 
| 8. | Iterator | iterate through menu buttons while taking care of the logic of changing font colors | 
| 9. | Flyweight | all image textures are in a separate class and are loaded once and then reused |

## Screenshots
### Menu
![menu](https://user-images.githubusercontent.com/69964767/150356642-e621e873-a8fc-4561-ac3d-12ed908e3ba0.png)

### Settings
![settings](https://user-images.githubusercontent.com/69964767/150356690-1d69a4da-e06e-4362-8543-62991ab009f2.png)

### Game
![game_start](https://user-images.githubusercontent.com/69964767/150356728-bbe9c5de-83d3-4dc0-8690-e3c6b460f9d5.png)
![game_playing](https://user-images.githubusercontent.com/69964767/150356741-ab78a1c6-8616-487b-8511-bb7c58467597.png)
![game_gameover](https://user-images.githubusercontent.com/69964767/150356756-d098d425-50a1-4065-a414-275f48ba0e89.png)

# Pixel Kingdom  
This is a point and click game created with the Java game development framework LibGDX.

## Installation
* Download the project files from the repository.
* Open the project in your preferred IDE.
* Run the project using the DesktopLauncher class.


## Gameplay
The game is a Pacman-like game where the player controls a character that moves around a grid-like environment, collecting resources and avoiding enemies.

## Controls
Click a tile to move the character around the environment.

## Resources
* Trees: Can be collected for points.
* Rocks: Cannot be collected but can be used to block enemies.
* Water: Cannot be collected and cannot be crossed.

## Enemies
* Ghosts: Will move around the environment and attempt to collide with the player. Colliding with a ghost will result in the player losing a life.
* Blinky: Will chase the player around the environment.
* Pinky: Will attempt to ambush the player by predicting their movements.
* Inky: Will move in a random pattern, occasionally chasing the player.
* Clyde: Will move towards the player if they are far away, but will flee if they get too close.

## Scoring
* Trees: 10 points each.
* Lives: 100 points each.

# Development
This game was developed using the Java game development framework LibGDX. The game features the tween game engine, including a TileGrid for managing the game environment, a camera system for managing the game view.

# Credits
This game was developed by [Cazpar].
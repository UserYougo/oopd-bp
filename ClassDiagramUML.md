@startuml

skinparam classAttributeIconSize 0                                                                                                                                                                                                                                  
skinparam linetype ortho

class HAN_Menace {
+{static} TITELSCENE: int
+{static} GAMESCENE: int
+{static} LOSTSCENE: int
+{static} WINSCENE: int
}

class GameScene {
-player: Player
+createSplitPlatforms(): void
}
class TitelScene
class WinScene
class LostScene

HAN_Menace ..> TitelScene : creates
HAN_Menace ..> GameScene  : creates
HAN_Menace ..> WinScene   : creates
HAN_Menace ..> LostScene  : creates

class Player {
-lives: int
-isOnGround: boolean
+loseLife(): void
}
interface LivesListener {
+onLivesChanged(int): void
}
class LivesDisplay {
+updateLives(int): void
}
class ScreenFlash {
+flash(): void
}

Player --> LivesListener
LivesDisplay ..|> LivesListener

class Boss
class EnemyEntity {
-currentDirection: Direction
}
class GhostEntity

class RocketEntity
class RocketSpawner {
-player: Player
-sceneWidth: double
+spawnEntities(): void
}
RocketSpawner ..> RocketEntity : spawns

class Platform

abstract class Item {
+onPickup(): void
}
class Coin
class BadCoin
class ScoreManager {
-{static} score: int
+{static} addPoints(int): void
+{static} removePoints(int): void
+{static} saveHighscore(): void
+{static} reset(): void
}

Coin --|> Item
BadCoin --|> Item
Coin    ..> ScoreManager : addPoints
BadCoin ..> ScoreManager : removePoints
Boss    ..> ScoreManager : saveHighscore

abstract class BaseButton
class Button {
-setScene: int
}
class ExitButton
class HeaderText

Button     --|> BaseButton
ExitButton --|> BaseButton
Button     ..> ScoreManager : reset

GameScene *-- Player
GameScene *-- Boss
GameScene *-- Platform
GameScene *-- LivesDisplay
GameScene *-- ScreenFlash
GameScene *-- RocketSpawner
GameScene ..> EnemyEntity : creates
GameScene ..> GhostEntity : creates
GameScene ..> Coin        : creates

TitelScene ..> Button     : creates
TitelScene ..> ExitButton : creates
TitelScene ..> HeaderText : creates
WinScene   ..> Button     : creates
WinScene   ..> ExitButton : creates
LostScene  ..> Button     : creates
LostScene  ..> ExitButton : creates
WinScene   ..> ScoreManager : getScore
LostScene  ..> ScoreManager : getScore

@enduml
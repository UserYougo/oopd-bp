````mermaid
classDiagram                                                                                                                                                                                                                                                        
      direction TB                                                                                                                                                                                                                                                    
                                                                                                                                                                                                                                                                      
      class HAN_Menace {
          +TITELSCENE: int$                                                                                                                                                                                                                                           
          +GAMESCENE: int$
          +LOSTSCENE: int$
          +WINSCENE: int$
      }

      %% ── Scenes ─────────────────────────────────────
      class TitelScene
      class GameScene {
          -player: Player
          +createSplitPlatforms(): void
      }
      class WinScene
      class LostScene

      HAN_Menace ..> TitelScene : creates
      HAN_Menace ..> GameScene  : creates
      HAN_Menace ..> WinScene   : creates
      HAN_Menace ..> LostScene  : creates

      %% ── Player ──────────────────────────────────────
      class Player {
          -lives: int
          -isOnGround: boolean
          +loseLife(): void
      }
      class LivesListener {
          <<interface>>
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

      %% ── Enemies ─────────────────────────────────────
      class Boss
      class EnemyEntity {
          -currentDirection: Direction
      }
      class GhostEntity

      %% ── Rocket ──────────────────────────────────────
      class RocketEntity
      class RocketSpawner {
          -player: Player
          -sceneWidth: double
          +spawnEntities(): void
      }
      RocketSpawner ..> RocketEntity : spawns

      %% ── Platform ────────────────────────────────────
      class Platform

      %% ── Items & Score ───────────────────────────────
      class Item {
          <<abstract>>
          +onPickup(): void
      }
      class Coin
      class BadCoin
      class ScoreManager {
          -score: int$
          +addPoints(int)$
          +removePoints(int)$
          +saveHighscore()$
          +reset()$
      }

      Coin --|> Item
      BadCoin --|> Item
      Coin    ..> ScoreManager : addPoints
      BadCoin ..> ScoreManager : removePoints
      Boss    ..> ScoreManager : saveHighscore

      %% ── Buttons / UI ────────────────────────────────
      class BaseButton {
          <<abstract>>
      }
      class Button {
          -setScene: int
      }
      class ExitButton
      class HeaderText

      Button --|> BaseButton
      ExitButton --|> BaseButton
      Button ..> ScoreManager : reset

      %% ── GameScene wires everything together ─────────
      GameScene *-- Player
      GameScene *-- Boss
      GameScene *-- Platform
      GameScene *-- LivesDisplay
      GameScene *-- ScreenFlash
      GameScene *-- RocketSpawner
      GameScene ..> EnemyEntity : creates
      GameScene ..> GhostEntity : creates
      GameScene ..> Coin        : creates

      %% ── Scene UI ────────────────────────────────────
      TitelScene ..> Button     : creates
      TitelScene ..> ExitButton : creates
      TitelScene ..> HeaderText : creates
      WinScene   ..> Button     : creates
      WinScene   ..> ExitButton : creates
      LostScene  ..> Button     : creates
      LostScene  ..> ExitButton : creates
      WinScene   ..> ScoreManager : getScore
      LostScene  ..> ScoreManager : getScore
````
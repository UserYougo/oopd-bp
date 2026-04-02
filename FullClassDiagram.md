````mermaid
  classDiagram                                                                                                                                                                                                                                                        
      direction TB                                                                                                                                                                                                                                                    
                                                                                                                                                                                                                                                                      
      %% Main Application                                                                                                                                                                                                                                             
      class HAN_Menace {                                                                                                                                                                                                                                              
          +int TITELSCENE$                                                                                                                                                                                                                                            
          +int GAMESCENE$
          +int LOSTSCENE$                                                                                                                                                                                                                                             
          +int WINSCENE$                                                                                                                                                                                                                                              
          +main(String[]) void$                                                                                                                                                                                                                                       
          +setupGame() void                                                                                                                                                                                                                                           
          +setupScenes() void                                                                                                                                                                                                                                         
      }
                                                                                                                                                                                                                                                                      
      %% Scenes
      class TitelScene {
          #HAN_Menace hanMenace
          +setupScene() void
          +setupEntities() void
      }
      class GameScene {
          #HAN_Menace hanMenace
          -Player player
          +setupScene() void
          +setupEntities() void
          +setupEntitySpawners() void
      }
      class LostScene {
          -HAN_Menace hanMenace
          +setupScene() void
          +setupEntities() void
      }
      class WinScene {
          -HAN_Menace hanMenace
          +setupScene() void
          +setupEntities() void
      }

      %% Player
      class LivesListener {
          <<interface>>
          +onLivesChanged(int) void
      }
      class Player {
          +double GROUND_SPEED$
          +double AIR_SPEED$
          -HAN_Menace hanMenace
          -Coordinate2D startPosition
          -boolean isOnGround
          -int lives
          -LivesListener livesListener
          +getLives() int
          +setLivesListener(LivesListener) void
          +loseLife() void
          +onPressedKeysChange(Set) void
          +notifyBoundaryTouching(SceneBorder) void
          +onCollision(List) void
      }

      %% Boss
      class Boss {
          -HAN_Menace hanMenace
          +onCollision(List) void
      }

      %% Hitbox hierarchy
      class Hitbox {
          +setHitBoxWidth(double) void
          +setHitBoxHeight(double) void
      }
      class DynamicHitbox {
          #setHitBoxWidth(double) void
          #setHitBoxHeight(double) void
      }
      class DynamicKillBox {
          +onCollision(List) void
      }

      %% Platform
      class Platform {
          -HAN_Menace hanMenace
          -double width
          -double height
          +updatePlatform(double, double) void
      }

      %% Static items
      class Item {
          <<abstract>>
          +onPickup() void*
          +onCollision(List) void
      }
      class Coin {
          -int value
          +onPickup() void
      }
      class BadCoin {
          -int value
          +onPickup() void
      }

      %% Score
      class ScoreManager {
          -int score$
          -ArrayList~Integer~ highscores$
          +addPoints(int) void$
          +removePoints(int) void$
          +getScore() int$
          +reset() void$
          +saveHighscore() void$
          +getHighscores() ArrayList$
      }

      %% Enemies
      class EnemyEntity {
          -HAN_Menace app
          -double width
          -double height
          -Direction currentDirection
          +setupEntities() void
          +notifyBoundaryTouching(SceneBorder) void
          +onCollision(List) void
      }
      class EnemyEntityAppearance
      class EnemyEntityDamage
      class EnemyEntityText

      class GhostEntity {
          -HAN_Menace app
          -double width
          -double height
          +setupEntities() void
          +notifyBoundaryTouching(SceneBorder) void
          +onCollision(List) void
      }
      class GhostEntityAppearance
      class GhostEntityDamage

      %% Rockets
      class RocketEntity {
          -HAN_Menace hanMenace
          -double width
          -double height
          +setupEntities() void
          +notifyBoundaryTouching(SceneBorder) void
      }
      class RocketEntityAppearance
      class RocketEntityDamage
      class RocketSpawner {
          -Player player
          -double sceneWidth
          -Random random
          +spawnEntities() void
      }

      %% UI
      class LivesDisplay {
          +updateLives(int) void
      }
      class ScreenFlash {
          +flash() void
      }
      class HeaderText {
          -HAN_Menace hanMenace
          -String text
      }

      %% Button hierarchy
      class BaseButton {
          <<abstract>>
          -Color defaultTextColor
          -Color defaultBackgroundColor
          -double width
          -double height
          -String text
          -BaseButtonText baseButtonText
          +setupEntities() void
          +onMouseEntered() void
          +onMouseExited() void
      }
      class BaseButtonBox
      class BaseButtonText {
          -Color textColor
          +onMouseEntered() void
          +onMouseExited() void
          #setTextColor(Color) void
      }
      class Button {
          #HAN_Menace hanMenace
          -String text
          -int setScene
          +onMouseButtonPressed(MouseButton, Coordinate2D) void
      }
      class ExitButton {
          +onMouseButtonPressed(MouseButton, Coordinate2D) void
      }

      %% ── Inheritance ──
      HAN_Menace ..> TitelScene : creates
      HAN_Menace ..> GameScene : creates
      HAN_Menace ..> LostScene : creates
      HAN_Menace ..> WinScene : creates

      Platform --|> Hitbox
      Item --|> Hitbox : (CircleEntity)
      Coin --|> Item
      BadCoin --|> Item

      DynamicKillBox --|> DynamicHitbox

      EnemyEntityDamage --|> DynamicKillBox
      GhostEntityDamage --|> DynamicKillBox
      RocketEntityDamage --|> DynamicKillBox

      Button --|> BaseButton
      ExitButton --|> BaseButton

      %% ── Compositions / Associations ──
      Player ..|> LivesListener : notifies
      LivesDisplay ..|> LivesListener : implements

      GameScene *-- Player
      GameScene *-- Boss
      GameScene *-- Platform
      GameScene *-- EnemyEntity
      GameScene *-- GhostEntity
      GameScene *-- RocketSpawner
      GameScene *-- LivesDisplay
      GameScene *-- ScreenFlash
      GameScene *-- Coin
      GameScene *-- BadCoin

      EnemyEntity *-- EnemyEntityAppearance
      EnemyEntity *-- EnemyEntityDamage
      EnemyEntity *-- EnemyEntityText
      GhostEntity *-- GhostEntityAppearance
      GhostEntity *-- GhostEntityDamage
      RocketEntity *-- RocketEntityAppearance
      RocketEntity *-- RocketEntityDamage
      RocketSpawner ..> RocketEntity : spawns
      RocketSpawner --> Player

      BaseButton *-- BaseButtonBox
      BaseButton *-- BaseButtonText

      Coin --> ScoreManager
      BadCoin --> ScoreManager
      Boss --> ScoreManager
      Button --> HAN_Menace
      Boss --> Player
````
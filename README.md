## Architecture
- Single activity
- splitting features into modules

## Gradle Setup
- Feature Version Catalog
- Explicit API Mode
- nonTransitive

## Задачки
- Передача общей модели из фитчи A в фитчу B
- Кейс когда мы в фитче A открываем экран из фитчи B, экран из фитчи B
  требует зависимости из своего фитче компонента
- Запуск одной и той же фичи несколько раз: навигация Фича A > B > A, с иницилизацией разных 
даггеровских компонентов у фитчи A
- Провайд зависимостей в java леджаси коде куда не получается встроить 
CoreActivity CoreFragment

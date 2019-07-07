# atm
This is legacy atm implementation for HackerU school

/*
    Функциональные требования
    1. Выдавать деньги
    2. Принимать деньги
    3. Переводить
    4. Информация по счету
    5. Авторизация (Логин и Пароль и Роль)
    6*. Хранилище: Емкость банкомата - колличество купюр и их
    7. Загрузка и забор денег (инициализация)
    8. Логирование
    Структура приложения(пэкэджи)
    1. Эндпоинт - точки взаимодействия клиента и приложения
    2. Сервисы
        - DA - data access - слой доступа к данным
            - получение списка логинов и паролей
            - получение информации о емкости банкомата
            - получегние счетов клиентов
            - получение логов
        - FG - fine-grain - мелкозернистые сервисы
            - логирование операций
        - CG - corse-grain - крупнозернистые или композитные сервисы
            - авторизация
            - выдача денег
            - прием денег
            - пополнение банкомата
            - перевод денег
            - забор денег
    3. Модели
        Счета - держатель, срок, денежки, номер
        Банкомат - емкость, количество средств, купюры
        Купюра
        Клиенты - Map<Credentials, Киенты>
        Credentials - логин, пароль, роль
    4. Реализации взаимодействия с данными
        - Файлы
        - Data Base
        - inMemory
    5. Клиент-серверное приложение
    4. Админка
 */
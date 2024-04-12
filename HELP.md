Домашнее задание по теме Spring IoC:

Напишите программу, которая будет спрашивать у пользователя фамилию и имя, выводить 5 вопросов теста из CSV-файла с возможными вариантами ответа, запрашивать ответ пользователя и выводить результат тестирования. Вопросы придумайте сами.

Требования:

    В приложении должна присутствовать объектная модель (отдаём предпочтение объектам и классам, а не строчкам и массивам/спискам строчек).
    Все зависимости должны быть настроены в IoC контейнере.
    CSV с вопросами читается именно как ресурс, а не как файл.
    Scanner, PrintStream и другие стандартные типы в контекст класть не нужно.
    Весь ввод-вывод осуществляется на английском языке.
    Конфигурация в виде Java + Annotation-based конфигурации.
    Добавьте файл настроек для приложения тестирования студентов.
    В конфигурационный файл можно поместить путь до CSV-файла, количество правильных ответов для зачёта – на ваше усмотрение.

Опционально: 

       9. Приложение должно корректно запускаться с помощью "java -jar"

Домашнее задание по теме Конфигурирование Spring-приложений:

Написать BeanPostProcessor, который выводит в лог все созданные бины в приложении.

    Должен работать для всех бинов в приложении, вне зависимости от способа их определения.
    Используйте slf4j фасад для вывода логов.
    *Предусмотрите настройку (property), которая задаёт пакет (или регулярное выражение для классов) для вывода бинов.

Домашнее задание по теме AOP, Spring AOP:

    Написать аспект логирования
    Должен выводить параметры вызова метода и возвращаемого значения.
    Аспект должен корректно выводить как и примитивы, так и объекты (toString)
    Должен включаться по собственной маркерной аннотации @Log
    Задание должно включать как сам аспект логирования, так и пример использования

*Опционально – вынести аспект логирования в отдельную библиотеку.
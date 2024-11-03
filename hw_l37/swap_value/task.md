Дана Map<String, String>, необходимо написать метод swapValue(Map<String,String> map, String key1, String key2), который поменяет местами значения для 2х заданных ключей. Если ключ(и) отсутствует в данной map, нужно создать соответствующие ключи со значением пустая строка.

Примеры: Пусть дана map {"a": "Bill", "b": "Ann"}

swapValue( map , "a","b"} -> {"a": "Ann", "b": "Bill"}

swapValue( map , "j","b"} -> {"a": "Bill", "b": "Ann","j":""}  
swapValue( map , "j","k"} -> {"a": "Bill", "b": "Ann","j":"","k":""}  
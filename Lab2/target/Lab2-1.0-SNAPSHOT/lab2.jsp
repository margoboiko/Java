<%--
  Created by IntelliJ IDEA.
  User: Rita
  Date: 5/28/2022
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Лабораторна робота 2</title>
    <link rel="stylesheet" href="styles/bootstrap.min.css">
</head>
<body>
<h4 class="text-center mt-4">Бойко Маргарита Геннадіївна</h4>
<h5 class="text-center mt-3">Варіант 1</h5>
<form action="/Lab2/table" method="get" id="tableValue">
    <div class="container mt-5">
        <div class="form-group row justify-content-center">
            <label class="col-2 col-form-label" for="title">
                Введіть заголовок:
            </label>
            <div class="col-4">
                <input name="title" class="form-control" id="title">
            </div>
        </div>

        <div class="form-group row justify-content-center">
            <label class="col-2 col-form-label" for="row">
                Кількість рядків таблиці:
            </label>
            <div class="col-4">
                <input name="row" type="number" min="0" max="20" class="form-control" id="row">
            </div>
        </div>

        <div class="form-group row justify-content-center">
            <label class="col-2 col-form-label" for="col">
                Кількість стовпців таблиці:
            </label>
            <div class="col-4">
                <input name="col" type="number" min="0" max="20" class="form-control" id="col">
            </div>
        </div>

        <div class="form-group row justify-content-center">
            <label class="col-2 col-form-label" for="color">
                Колір фону:
            </label>
            <div class="col-1">
                <input name="color" type="color" class="form-control" style="height: 48px;" id="color" value="#5f9ea0">
            </div>
        </div>
    </div>
    <div class="row justify-content-center mt-4">
        <button type="submit" value="Згенерувати таблицю" form="tableValue" class="btn btn-primary justify-content-center">Згенерувати таблицю</button>
    </div>
</form>
</body>
</html>
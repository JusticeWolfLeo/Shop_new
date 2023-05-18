<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product List</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
    </tr>
    </thead>
    <tbody>
    <#list products as product>
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.description}</td>
        </tr>
    </#list>
    </tbody>
</table>

<h2>Add New Product</h2>
<form method="post" action="/products/add">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br>

    <label for="description">Description:</label>
    <input type="text" id="description" name="description" required><br>

    <button type="submit">Add Product</button>
</form>
</body>
</html>

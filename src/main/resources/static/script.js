async function fetchProducts() {
    try {
        const response = await fetch("http://localhost:8080/api/products");

    if (response.status === 401) {
        window.location.href = "/login";
        return;
}

    if (response.status === 403) {
        alert("Access Denied");
        return;
}

    if (!response.ok) {
        throw new Error(`HTTP Error! ${response.status}`);
}

        const products = await response.json();

        const productsDiv = document.getElementById("products");

        if (products.length === 0) {
            productsDiv.innerHTML = "<p>No products found.</p>";
            return;
        }

        productsDiv.innerHTML = products.map(product => `
            <div>
                <h3>${product.name}</h3>
                <p>Price: ${product.price}</p>
                <p>${product.description}</p>
                <hr>
            </div>
        `).join("");

    } catch (error) {
        console.error("Error fetching products:", error);
    }
}

fetchProducts();
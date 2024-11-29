// Mock data for cars
const cars = [
  { id: 1, name: "Car 1", description: "Description of car 1", price: 20000, image: "https://via.placeholder.com/250x150" },
  { id: 2, name: "Car 2", description: "Description of car 2", price: 25000, image: "https://via.placeholder.com/250x150" },
  { id: 3, name: "Car 3", description: "Description of car 3", price: 30000, image: "https://via.placeholder.com/250x150" }
];

// Cart to store selected cars
let cart = [];

// Function to display available cars
function loadCars() {
  const carsList = document.getElementById('cars-list');
  carsList.innerHTML = '';
  cars.forEach((car, index) => {
    const carItem = document.createElement('div');
    carItem.classList.add('car-item');
    carItem.style.animationDelay = `${index * 0.2}s`; // Staggered animations
    carItem.innerHTML = `
      <img src="${car.image}" alt="${car.name}">
      <h3>${car.name}</h3>
      <p>${car.description}</p>
      <p><strong>$${car.price}</strong></p>
      <button onclick="addToCart(${car.id})">Buy</button>
    `;
    carsList.appendChild(carItem);
  });
}

// Function to add a car to the cart
function addToCart(carId) {
  const car = cars.find(c => c.id === carId);
  if (car) {
    cart.push(car);
    alert(`${car.name} added to cart!`);
  }
}

// Function to show the cart
function showCart() {
  const modal = document.getElementById('cart-modal');
  const cartItems = document.getElementById('cart-items');
  cartItems.innerHTML = '';
  cart.forEach(car => {
    const listItem = document.createElement('li');
    listItem.textContent = `${car.name} - $${car.price}`;
    cartItems.appendChild(listItem);
  });
  modal.style.display = 'flex';
}

// Function to close the cart modal
function closeCart() {
  const modal = document.getElementById('cart-modal');
  modal.style.display = 'none';
}

// Function to log out
function logout() {
  alert("You have logged out!");
  // Implement actual logout logic here
}

// Function to show home page
function showHome() {
  loadCars(); // Reload cars list on home click
}

// Initialize the page
document.addEventListener('DOMContentLoaded', loadCars);

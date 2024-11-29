
const menuToggle = document.getElementById("mobile-menu");
   const navLinks = document.querySelector(".nav-links");

   menuToggle.addEventListener("click", () => {
       navLinks.classList.toggle("active");
   });

    // Function to check if an element is visible in the viewport
    function isInViewport(element) {
        const rect = element.getBoundingClientRect();
        return (
            rect.top >= 0 &&
            rect.left >= 0 &&
            rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&
            rect.right <= (window.innerWidth || document.documentElement.clientWidth)
        );
    }

    document.addEventListener("scroll", function () {
        const popularCars = document.querySelector(".popular-cars");
        const carCards = document.querySelectorAll(".car-card");

        // Add the 'show' class when the .popular-cars section is visible
        if (isInViewport(popularCars)) {
            popularCars.classList.add("show");

            // Delay animation for each car card
            carCards.forEach((card, index) => {
                setTimeout(() => {
                    card.classList.add("show");
                }, index * 200); // Stagger each card animation by 200ms
            });
        }
    });
	   
	
	



    // Sample data for the bubble chart
    var data = {
        datasets: [{
          label: 'this week',
          data: [
            { x: 'buyers', y: 12, r: 15 }, // Bubble 1
            { x: "tenants", y: 13, r: 13 }, // Bubble 1
            { x: "sellers", y: 15, r: 21 }, // Bubble 2
            { x: "landlords", y: 16, r: 13 }  // Bubble 3
          ],
          backgroundColor: [
            'rgba(255, 217, 143, 1)',
            'rgba(193, 225, 255, 1)',
            'rgba(253, 255, 180, 1)',
            'rgba(255, 164, 152, 1)'
        ],
        borderColor: [
            'rgba(255, 200, 118, 1)',
            'rgba(161, 227, 255, 1)',
            'rgba(253, 255, 158, 1)',
            'rgba(255, 148, 134, 1)'
        ],
          hoverBackgroundColor: 'rgba(255, 99, 132, 0.8)', // Hover color
        }]
      };
  
      // Configuration options
      var options = {
        scales: {
            x: {
                type: 'category', // Use category scale for x-axis
                labels: ['buyers', 'tenants', 'sellers', 'landlords'] // Define your categories here
              },
          y: {
            type: 'linear',
            position: 'left'
          }
        },
        plugins: {
            tooltip: {
              titleFont: {
                size: 24 // Change the title font size
              },
              bodyFont: {
                size: 24 // Change the body font size
              }
            }
          }
      };
  
      // Get the canvas element
      var ctx = document.getElementById('myBubbleChart').getContext('2d');
  
      // Create the bubble chart
      var myBubbleChart = new Chart(ctx, {
        type: 'bubble',
        data: data,
        options: options
      });
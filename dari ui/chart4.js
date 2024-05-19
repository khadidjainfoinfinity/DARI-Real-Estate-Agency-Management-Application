var ctx = document.getElementById('myChart3').getContext('2d');

var myChart = new Chart(ctx, {
    type: 'pie',
    data: {
        labels: ['buyers', ' tenants', 'sellers', 'landlords'],
        datasets: [{
            label: 'we have',
            borderRadius: 0,
            data: [9, 11, 13, 12],
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
            borderWidth: 3,
            barThickness: 60 
        }]
    },
    ooptions: {
        interaction: {
            intersect: false,
          },
         scales: {
        y: {
            ticks: {
                color: 'red' // Set the color of the labels on the y-axis to red
            }
        },
        x: {
            ticks: {
                color: 'blue' // Set the color of the labels on the x-axis to blue
            }
        }
    },
        plugins: {
            title: {
                display: true,
                color:  'rgba(255, 255, 255, 1)'
            },
            
            legend: {
                labels: {
                    font: {
                        size: 22,
                        color : 'rgba(255, 255, 255, 1)'
                    }
                   
                }
            }
        },
        
    }
    
});
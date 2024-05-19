var ctx = document.getElementById('myChart1').getContext('2d');

var myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: ['m1', 'm2', 'm3'],
        datasets: [{
            label: '3 months progress',
            borderRadius: 20,
            data: [11, 10, 12],
            backgroundColor: [
                'rgba(255, 217, 143, 1)',
                'rgba(193, 225, 255, 1)',
                'rgba(253, 255, 180, 1)',
            ],
            borderColor: [
                'rgba(255, 200, 118, 1)',
                'rgba(161, 227, 255, 1)',
                'rgba(253, 255, 158, 1)',
            ],
            borderWidth: 3,
            barThickness: 6 
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
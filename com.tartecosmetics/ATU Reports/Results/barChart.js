            $(document).ready(function(){
                var s1 = [1,1,2,2,1,2,2,3,5,5,3,3,5,0,0,5,5,5,6,1,3,1,0,2,6,6,1,1,6,2,2,2,2,2,1,1,1,1,6,9,9,4,4,6,6,6,6,6,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0,1,1,1,0,1,0,1,1,0,0,0,0,0,1,0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,0,1,1,1,1,1,1,0,1,1,1,0,1,0,0,1,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,5,1,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,2,0,0,0,0,3,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,0,0,0,0,0,0,1,1,1];
                var s2 = [5,5,4,4,5,4,4,3,1,1,3,3,1,6,6,1,1,1,0,0,0,0,5,0,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0,0,2,2,0,0,0,0,0,1,1,0,5,5,5,0,0,0,0,5,1,1,1,0,1,1,0,0,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,0,1,1,1,1,1,0,1,1,1,1,1,0,0,0,1,0,1,0,0,1,1,1,1,1,0,1,1,1,0,1,0,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,0,1,0,0,0,0,0,0,1,0,0,0,1,0,1,1,0,1,1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,0,0,1,1,0,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,5,0,0,5,5,5,1,1,1,0,4,4,0,4,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,3,0,0,0,0,2,0,3,5,0,5,0,5,0,0,0,0,0,0,0,0,4,2,2,0,0,5,0,0,0,0,0,0,0,0,1,1,0,0,0,0,1,1,1,1,1,1,0,0,0];
                var s3 = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0];

var ticks = [22,23,24,25,26,27,28,29,30,31];    $.jqplot('bar', [s1, s2, s3], {
        animate: true,axesDefaults:{min:0,tickInterval: 1},        seriesColors: ["#7BB661", "#E03C31", "#21ABCD"],
        stackSeries: false,
        seriesDefaults: {
            renderer: $.jqplot.BarRenderer,
            pointLabels: {show: true}
            , rendererOptions: {barWidth: 12, barMargin: 25, fillToZero: true}
        }
        ,
        grid: {borderColor: '#ffffff', background: '#ffffff',
            borderWidth: 0.5, // pixel width of border around grid.
            shadow: false // draw a shadow for grid.
        }
        ,
        legend: {
            show: true,
            location: 'e',
            placement: 'outside',
            labels: ['Passed', 'Failed', 'Skipped']
        },
        axes: {
            xaxis: {
                renderer: $.jqplot.CategoryAxisRenderer,
                ticks: ticks,
                label: "Run Number"
            }
            ,
            yaxis: {
                label: "TC Number",
                tickOptions: {
                    formatString: "%dtc"
                }
            }
        }
    });
});
var options={};
window.onscroll=function(){
    var top=document.body.scrollTop;
    var clientHeight=document.body.clientHeight+top;
    for(var id in options){
        var offsetTop=document.getElementById(id).offsetTop;
        var offsetHeight=document.getElementById(id).offsetHeight;
        var bottom=top+clientHeight;
        var offsetBottom=offsetTop+offsetHeight;
        if(top<=offsetTop&&bottom>=offsetBottom) {
            if(autoRestore)restoreChart(id);
            else initializeChart(id);
        }
    }
};
function load(id,url){
    var xmlhttp;
    if (window.XMLHttpRequest)
    {// code for IE7+, Firefox, Chrome, Opera, Safari\n"
    xmlhttp=new XMLHttpRequest();
    }
    else
    {// code for IE6, IE5
    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function()
    {if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
        var option=eval("("+xmlhttp.responseText+")");
        var chart=echarts.init(document.getElementById(id));
        chart.setOption(option);
    }
    };
    xmlhttp.open("GET",url,true);
    xmlhttp.send();
}
function restoreChart(id){
    var dom=document.getElementById(id);
    var myChart=echarts.getInstanceByDom(dom);
    if(!myChart)echarts.init(dom).setOption(options[id]);
    else myChart.restore();
}
function initializeChart(id){
    var dom=document.getElementById(id);
    var myChart=echarts.getInstanceByDom(dom);
    if(!myChart)echarts.init(dom).setOption(options[id]);
}
document.addEventListener('DOMContentLoaded', function() {
    const button = document.getElementById('testButton');
    const result = document.getElementById('result');
    
    button.addEventListener('click', function() {
        const currentTime = new Date().toLocaleString();
        result.textContent = `按钮点击时间：${currentTime}`;
        result.style.color = '#27ae60';
    });
}); 
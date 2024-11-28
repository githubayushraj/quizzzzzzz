window.onload = function() {

    const quizScore = localStorage.getItem('quizScore');
    const totalQuestions = localStorage.getItem('totalQuestions');

    if (quizScore && totalQuestions) {

        document.getElementById('quiz-result').textContent = `${quizScore} / ${totalQuestions}`;


        const retryButton = document.getElementById('retry-button');
        if (retryButton) {
            retryButton.style.display = 'block'; 
        }
    } else {

        document.getElementById('quiz-result').textContent = 'No results available.';
    }
};

// Retry quiz function
function retakeQuiz() {
    // Reset localStorage for a fresh start
    localStorage.removeItem('quizScore');
    localStorage.removeItem('totalQuestions');
    localStorage.removeItem('timeLeft');

    window.location.href = 'index.html';
}

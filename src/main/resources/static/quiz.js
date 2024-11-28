let currentQuestionIndex = 0;
let questions = [];
let correctAnswers = 0;
let totalQuestions = 0; 
let timeLeft;
let isQuizOver = false;

async function fetchQuestions() {
    let quizType = localStorage.getItem('quizType');
    try {
        let response = await fetch(`http://localhost:8080/api/${quizType}`);
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        questions = await response.json(); 
        totalQuestions = questions.length;
        document.getElementById('total-questions').textContent = totalQuestions;
        document.getElementById('quizType').textContent = quizType.charAt(0).toUpperCase() + quizType.slice(1);
        timeLeft = totalQuestions * 60; 
        startTimer();
        displayQuestion();
    } catch (error) {
        console.error('Error fetching questions:', error);
        document.getElementById('question-text').innerHTML = 
            "Failed to load questions. <button onclick='fetchQuestions()'>Retry</button>";
    }
}

function displayQuestion() {
    if (questions.length === 0 && isQuizOver) return;

    const questionText = document.getElementById('question-text');
    const optionsContainer = document.getElementById('options-container');
    const currentQuestion = questions[currentQuestionIndex];

    questionText.textContent = currentQuestion.questionText;
    optionsContainer.innerHTML = '';

  
    document.getElementById('current-question').textContent = currentQuestionIndex + 1;

    // Loop through options and create buttons
    currentQuestion.options.forEach(option => {
        const button = document.createElement('button');
        button.textContent = option; // Show each option
        button.className = 'option';
        button.onclick = () => checkAnswer(option); // Call checkAnswer on click
        optionsContainer.appendChild(button);
    });

}

function checkAnswer(selectedOption) {
    if(isQuizOver) return
    const currentQuestion = questions[currentQuestionIndex];
    const options = document.querySelectorAll('.option');

    options.forEach(option => {
        if (option.textContent === currentQuestion.correctAnswer) {
            option.style.backgroundColor = 'green'; // Highlight correct answer
        } else if (option.textContent === selectedOption) {
            option.style.backgroundColor = 'red'; // Highlight selected wrong answer
        }
    });

    if (selectedOption === currentQuestion.correctAnswer) {
        correctAnswers++; 
    }

    setTimeout(nextQuestion, 1000); // Delay before moving to the next question
}

function nextQuestion() {
    if(isQuizOver) return;
    if (currentQuestionIndex < questions.length - 1) {
        currentQuestionIndex++;
        displayQuestion();
    } else {
        localStorage.setItem('quizScore', correctAnswers); // Save the score in localstorage
        localStorage.setItem('totalQuestions', totalQuestions); // Save total questions in localstorage
        window.location.href = 'result.html'; 
    }
}

function previousQuestion() {
    if(isQuizOver) return;
    if (currentQuestionIndex > 0) {
        currentQuestionIndex--;
        displayQuestion();
    }
}

function startTimer() {
    const savedTimeLeft = parseInt(localStorage.getItem('timeLeft')) || timeLeft;
    timeLeft = savedTimeLeft;

    const countdown = setInterval(() => {

        if (timeLeft < 0) {
            clearInterval(countdown); // Stop the countdown
            document.getElementById('timer').textContent = "Time's up!"; // Display time's up message
            endQuiz();
            return; 
        }

        const minutes = Math.floor(timeLeft / 60);
        const seconds = timeLeft % 60;
        document.getElementById('timer').textContent = `${minutes}:${seconds.toString().padStart(2, '0')}`;

        timeLeft--;


        if (timeLeft >= 0) {
            localStorage.setItem('timeLeft', timeLeft);
        }
    }, 1000);
}


function endQuiz() {
    isQuizOver = true;
    localStorage.setItem('quizScore', correctAnswers); 
    localStorage.setItem('totalQuestions', totalQuestions); 

    const retryButton = document.getElementById('retry-button');
    if (retryButton) {
        retryButton.style.display = 'block'; // Show Retry button on the results page
    }

    setTimeout(() => {
        window.location.href = "result.html"; 
    }, 500); // Delay slightly to ensure the UI updates
}



window.onload = fetchQuestions;



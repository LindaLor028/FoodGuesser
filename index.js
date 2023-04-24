var letter_graphs = [
    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
    "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
    "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6",
    "7", "8", "9"
];

var digraphs = [
    "ch", "sh", "ph", "th", "wh"
];

var bebebese = "res/audio/bebebese_slow.wav";

var playbackSpeedMin = 2.5;
var playbackSpeedMax = 3.0;
var playbackSpeed = null;
var sentence = '';

function onSpeakButtonClick() {
    // sing(document.getElementById("etOpening").value, 1.0, 1.0);
    singBuns();
}


function speakSentence() {
    speakNextCharacter();
}

/**
 * https://masteringjs.io/tutorials/fundamentals/wait-1-second-then
 * @param {*} time 
 * @returns 
 */
function delay(time) {
    return new Promise(resolve => setTimeout (resolve, time));
}

async function singBuns() {
    sing(document.getElementById("etOpening").value, 1.0, 4.0);
    sing(document.getElementById("etOpening").value, 1.0, 3.0);
    sing(document.getElementById("etBridge").value, 1.0, 1.0);
    // await delay(1000);
    sing(document.getElementById("etOpening").value, 1.0, 1.0);
    

}
function sing(text, rate, pitch) {
    const speech = new SpeechSynthesisUtterance(text);
    speech.pitch = pitch;
    speech.rate = rate;
    window.speechSynthesis.speak(speech);

}

function speakNextCharacter() {
    
}

function getCharacterAudioFile(character) {
    if (character.match(/[a-z]/i)) {
        return "res/audio/" + character + ".wav";
    } else if (character == " ") {
        return null;
    } else {
        return bebebese;
    }
}

function buildSentence(sentence) {
    sentence = sentence.toLowerCase();
    sentence = replaceSwearWords(sentence);
    sentence = replaceParentheses(sentence);
    //sentence = removeSpaces(sentence);
    return sentence
}

function replaceSwearWords(sentence) {
    var swearWords = ["fuck", "shit", "piss", "crap", "bugger"]
    for (var eachWord = 0; eachWord < swearWords.length; eachWord++) {
        sentence = sentence.replace(swearWords[eachWord], "*".repeat(swearWords[eachWord].length));
    }
    return sentence;
}

function replaceParentheses(sentence) {
    while (sentence.includes("(") || sentence.includes(")")) {
        var start = sentence.indexOf("(");
        var end = sentence.indexOf(")");
        sentence = sentence.substring(0, start) + 
            "*".repeat(end-start-1) + 
            sentence.substring(end + 1, sentence.length);
    }

    return sentence;
}

function removeSpaces(sentence) {
    sentence = sentence.replace(" ", "");
    return sentence;
}
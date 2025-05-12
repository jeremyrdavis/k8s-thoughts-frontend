import "./style.css";
import { fetchRandomThought, createThoughtElement } from "./thought.js";

document.querySelector("#app").innerHTML = `
  <div>
    <h1>Thought of the Day</h1>
    <div id="thought-container" class="thought-container">
      <p>Loading thought...</p>
    </div>
    <button id="new-thought" class="new-thought-btn">Another Thought</button>
  </div>
`;

// Fetch and display a random thought
async function loadRandomThought() {
  const thoughtContainer = document.querySelector("#thought-container");
  const thought = await fetchRandomThought();
  thoughtContainer.innerHTML = createThoughtElement(thought);
}

// Load the initial thought
loadRandomThought();

// Add click handler for the new thought button
document
  .querySelector("#new-thought")
  .addEventListener("click", loadRandomThought);

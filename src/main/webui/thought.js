export async function fetchRandomThought() {
  try {
    const response = await fetch("/api/thoughts/random");
    if (!response.ok) {
      throw new Error("Failed to fetch thought");
    }
    return await response.json();
  } catch (error) {
    console.error("Error fetching thought:", error);
    return null;
  }
}

export function createThoughtElement(thought) {
  if (!thought) {
    return '<div class="error">Failed to load thought</div>';
  }

  return `
        <div class="thought-card">
            <p class="thought-text">${thought.thought}</p>
            <p class="thought-author">- ${thought.author}</p>
            <p class="thought-date">${new Date(
              thought.day
            ).toLocaleDateString()}</p>
        </div>
    `;
}

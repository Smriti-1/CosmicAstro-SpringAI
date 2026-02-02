
  const API_URL = "http://localhost:8080/api/cosmic-astro/ask";

  function formatAstroText(text) {
    return text
      .replace(/^# (.*$)/gim, "<h1>$1</h1>")
      .replace(/^## (.*$)/gim, "<h2>$1</h2>")
      .replace(/\*\*(.*?)\*\*/gim, "<strong>$1</strong>")
      .replace(/^\* (.*$)/gim, "<li>$1</li>")
      .replace(/(<li>.*<\/li>)/gims, "<ul>$1</ul>")
      .replace(/\n\n/g, "<br>");
  }

  $("#askBtn").on("click", function () {
    const dob = $("#dob").val();
    const time = $("#time").val();
    const place = $("#place").val();
    const question = $("#question").val();

    if (!dob || !time || !place || !question) {
      alert("Please fill all fields 🌕");
      return;
    }

    $("#answer").hide();
    $("#loader").show();

    $.ajax({
      url: API_URL,
      method: "POST",
      contentType: "application/json",
      data: JSON.stringify({
        dateOfBirth: dob,
        timeOfBirth: time,
        placeOfBirth: place,
        question: question
      }),
      success: function (response) {
        $("#loader").hide();
        $("#answer")
          .html(formatAstroText(response))
          .fadeIn();
      },
      error: function () {
        $("#loader").hide();
        $("#answer")
          .html("<p>Something went wrong. Please try again 🌑</p>")
          .fadeIn();
      }
    });
  });
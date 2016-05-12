window.onload = function() {

  var username = "Shin" + (Math.random() * 1000 >> 0);

  var settings = {
    "register"              : ["POST",   "/user",    { username: username, password: "123123" }],
    "login"                 : ["POST",   "/session", { username: username, password: "123123" }],
    "logout"                : ["DELETE", "/session", {}],
    "get-current-user"      : ["GET",    "/session", {}],
    "get-one-user"          : ["GET",    "/user/1",  {}],
    "get-films"             : ["GET",    "/films?city=440100",   {}],
    "get-film-detail"       : ["GET",    "/films/1",   {}],
    "get-feasible-cinemas"  : ["GET",    "/films/1/cinemas",   {}],
    "get-cinema-detail"     : ["GET",    "/cinemas/1",   {}],
    "get-cinema-rooms"      : ["GET",    "/cinemas/1/rooms",   {}],
    "get-room-seats"        : ["GET",    "/rooms/1/seats",   {}]
  };

  for (var key in settings) {
    (function(className) {
      $(".btn." + className).click(function() {
        var options = settings[className];
        $.ajax({
          url: options[1],
          type: options[0],
          dataType: "json",
          data: options[0] == "POST" ? JSON.stringify(options[2]) : "",
          headers: {
            'Content-Type': "application/json;charset=utf-8"
          },
          success: handleSuccess(key, options),
          error: handleError(key, options)
        });
      });
    })(key);
  }

  var $display = $("#display > pre");

  function handleSuccess(key, options) {
    return function(result) {
      var obj = {
        api: options[0] + " " + options[1],
        result: result
      };
      $display.html(JSON.stringify(obj, " ", 4));
    };
  }

  function handleError(key, options) {
    return function(error) {
      $display.html(JSON.stringify(error.responseJSON, " ", 4));
    }
  }

};

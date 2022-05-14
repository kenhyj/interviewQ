function startTimer(callback, interval) {
    // Write the code that goes here
    let counter = 1;
      
    let stopper = () => callback(counter);  

    let st = () => setTimeout(stopper, interval);
    
    while( stopper() ) {
      counter++;
      // stopper = callback(counter);
    }
    // clearInterval(st);
    // setTimeout()
  }
  
  function callback(counter) {
    console.log(counter);
    return counter < 5;
  }
  
  // Expected: 1, 2, 3, 4, 5 with 50ms interval.
  startTimer(callback, 2000);
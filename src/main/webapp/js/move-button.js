$(document).ready(function () {
	
	let innerText = null;
	
	
	$('.moveable-excelPage').draggable({
		containment: 'document',
	    helper: 'clone',
	    opacity: 0.70,
	    appendTo: '.draggableContainer',
	    start: function() {
	    	innerText = $(this).text();
	    }
	});
	
	 $(".droppableExcelList").droppable({
     drop: function() {
         $(this).css({
             backgroundColor: ""
         });
         $(this).val(innerText);
         innerText = null;
     },
     over: function() {
         $(this).css({
             backgroundColor: "lightBlue"
         });
     },
     out: function () {
         $(this).css({
             backgroundColor: ""
         });
     }
	});
	
//	let currentDroppable = null;
//	
//	$('.moveable').mousedown(function(event) {
//		let ball = this;
//		
//	      let shiftX = event.clientX - ball.getBoundingClientRect().left;
//	      let shiftY = event.clientY - ball.getBoundingClientRect().top;
//
//	      ball.style.position = 'absolute';
//	      ball.style.zIndex = 1000;
//	      document.body.append(ball);
//
//	      moveAt(event.pageX, event.pageY);
//
//	      function moveAt(pageX, pageY) {
//	        ball.style.left = pageX - shiftX + 'px';
//	        ball.style.top = pageY - shiftY + 'px';
//	      }
//
//	      function onMouseMove(event) {
//	        moveAt(event.pageX, event.pageY);
//
//	        ball.hidden = true;
//	        let elemBelow = document.elementFromPoint(event.clientX, event.clientY);
//	        ball.hidden = false;
//
//	        if (!elemBelow) return;
//
//	        let droppableBelow = elemBelow.closest('.droppableExcelList');
//	        if (currentDroppable != droppableBelow) {
//	          if (currentDroppable) { // null when we were not over a droppable before this event
//	            leaveDroppable(currentDroppable);
//	          }
//	          currentDroppable = droppableBelow;
//	          if (currentDroppable) { // null if we're not coming over a droppable now
//	            enterDroppable(currentDroppable, ball, onMouseMove);
//	          }
//	        }
//	      }
//
//	      document.addEventListener('mousemove', onMouseMove);
//
//	      ball.onmouseup = function() {
//	        document.removeEventListener('mousemove', onMouseMove);
//	        ball.onmouseup = null;
//	      };
//
//	    });
//	
// 
//	
//	    function enterDroppable(elem, ball, onMouseMove) {
//	      elem.style.borderColor = "red";
//	      ball.onmouseup = function(point) {
//		        document.removeEventListener('mousemove', onMouseMove);
//		        let elemBelow = document.elementFromPoint(point.clientX, point.clientY);
//		        let droppableBelow = elemBelow.closest('.droppableExcelList');
//		        alert(point.clientX, point.clientY)
//		        droppableBelow.setAttribute('value', ball.innerHTML);
////		        ball.onmouseup = null;
//		      };
////	      let elemBelow = document.elementFromPoint(event.clientX, event.clientY);
////	      elemBelow.onmouseup(function (elem) {
////	    	  alert("op");
////	      });
////	      $('.moveable').mouseup(function(){
////		        elem.setAttribute('value', ball.innerHTML);
////		        ball.hidden = true;
////		        ball = null;
////		        document.removeEventListener('mousemove', onMouseMove);
////		        return;
////		      });
////	      $(".droppableExcelList").mouseup().setAttribute('value', ball.innerHTML);
////	    	  elem.mouseup(function() {
////	    	    elem.setAttribute('value', ball.innerHTML);
////	    	  })
////	    	  	elem.setAttribute('value', ball.innerHTML);
////		        document.removeEventListener('mousemove', onMouseMove);
////		        ball.onmouseup = null;
////		        return;
//     
//	    }
//
//	    
//	    function leaveDroppable(elem) {
//	      elem.style.borderColor = '';
//	    }  	    
});


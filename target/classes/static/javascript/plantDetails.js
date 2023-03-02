//HttpSession session= request.getSession(false);
//
//if(session != null && session.getAttribute("email") != null){
//
//    String userEmail= (String)session.getAttribute("email");
//    List<Plant>userPlants= plantService.getUserPlants(userEmail);
//}else{
//    List<Plant> allPlants= plantService.getAllPlants();
//
//}

const id = document.querySelector('#id');
const name = document.querySelector('#local-name');
const species = document.querySelector('#scientific-name');
const description = document.querySelector('#description');
const careTips = document.querySelector('#care-tips');
const deleteBtn=document.querySelector('.btn-danger');
const updateBtn=document.querySelector('.btn-primary');

const form = document.querySelector('#plant-form');
const headers = {
    'Content-Type':'application/json'
}
const seeAllTips= document.getElementById("seeAllTips");
const seeAllPlants= document.getElementById("seeAllPlants").value;
const submitBtnForTips= document.getElementById('submitBtnForTips');
function getUserPlants(){
    const userId= sessionStorage.getItem("userId");
    console.log("getUserPlants")
    fetch('http://localhost:8080/api/userPlants/${userId}')
    .then(response=>{
        if(response.ok){
            return response.json();
        }
        throw new Error('Network response was not Ok.');
    })
    .then(data=>{
        seeCard(data);
    })
    .catch(error=>{ console.error('There was a problem with the fetch operation: ', error)})


}






form.addEventListener('submit', (event) => {
  event.preventDefault(); // prevent form from submitting normally

  const name = document.querySelector('#local-name').value;
    const species = document.querySelector('#scientific-name').value;
    const description = document.querySelector('#description').value;
    const careTips = document.querySelector('#care-tips').value;


  // get form data

  const data = {
    name,
    species,
    description,
    careTips,
  };

  // send POST request
  fetch('http://localhost:8080/api/saveplant', {
    method: 'POST',
    body: JSON.stringify(data),
    headers: {
          'Content-Type': 'application/json'
    },
  })
  .then(response => {
    if (response.ok) {
      window.location.href = '/home.html'; // redirect to success page
    } else {
      throw new Error('Failed to create plant.');
    }
  })
  .catch(error => {
    console.error(error);
    alert('Failed to create plant.');
  });
});

const plantsTable = document.getElementById('plantsTable');

// Get data from API and loop through each plant object
fetch('http://localhost:8080/api/allplants')
  .then(response => response.json())
  .then(data => {
    data.forEach(plant => {
      // Create a new row for each plant object
      const row = plantsTable.insertRow();


      // Add data to the row cells
      row.insertCell().textContent = plant.id;
      row.insertCell().textContent = plant.name;
      row.insertCell().textContent = plant.species;
      row.insertCell().textContent = plant.description;
      row.insertCell().textContent = plant.careTips;
      row.insertCell().innerHTML = `<img src="images/${plant.name}.jpg" alt="${plant.name}" width="200" height="200">`;
      // Add event listener to the row
      row.addEventListener('click', () => {
        id.textContent=`${plant.id}`;
        name.value=`${plant.name}`;
         species.value=`${plant.species}`;
        description.textContent=`${plant.description}`;
        careTips.textContent=`${plant.careTips}`;
      });
    });
  })
  .catch(error => console.error(error));
//submitBtnForTips.addEventListener('submit',)

deleteBtn.addEventListener('click', ()=>{
    if(!id.textContent){
        alert("No row is selected");
    }else{
        const id_value=id.textContent;
        fetch("http://localhost:8080/api/deletePlant/"+id_value, {
          method: 'DELETE',
        })
          .then(response => {
            if (response.ok) {
             window.location.href = '/home.html'; // redirect to success page
              // Plant deleted successfully
            } else {
              throw new Error('Failed to delete plant');
            }
          })
          .catch(error => {
            console.error(error);
          });
    }
})

updateBtn.addEventListener('click', ()=>{
    if(!id.textContent){
        alert("No row is selected");
    }else{
      const name = document.querySelector('#scientific-name').value;
        const species = document.querySelector('#local-name').value;
        const description = document.querySelector('#description').value;
        const careTips = document.querySelector('#care-tips').value;
          const data = {
            name,
            species,
            description,
            careTips,
          };
        const id_value=id.textContent;
        fetch("http://localhost:8080/api/updatePlant/"+id_value, {
          method: 'PUT',
          body: JSON.stringify(data),
          headers: {
              'Content-Type': 'application/json'
          },
        })
          .then(response => {
            if (response.ok) {
             window.location.href = '/home.html'; // redirect to success page
              // Plant deleted successfully
            } else {
              throw new Error('Failed to delete plant');
            }
          })
          .catch(error => {
            console.error(error);
          });
    }
})
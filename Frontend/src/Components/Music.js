import axios from 'axios';
import React, { useEffect, useState } from 'react'

const Music= () => {
   // making music state for Get request here 
    const[music ,setMusic]=useState([]);

    // making state for the Post Request here
    const[newData,setNewData]=useState({
        "id":0,
        "songName":"",
        "songDuration":0
    })

    // getData for executing  get request 
    const getData= async()=>{
        const apiResponse= await axios.get("http://localhost:8080/music");
        setMusic(apiResponse.data.data);
    }

    const onPost=async ()=>{
  const apiResponse= await axios.post("http://localhost:8080/save",newData);
     alert(apiResponse.data.msg);
     getData();
    }

const ondelete = async (id) => {
  const apiResponse = await axios.delete(`http://localhost:8080/delete/${id}`);
  alert(apiResponse.data.msg);
  getData(); 
};


   useEffect(()=>{
    getData();
   },[]);



 const formData = (data, key)=>{
       setNewData(copyMusic=>({
        ...copyMusic,[key]:data.target.value
       }));
 }


  return (
    <div>
        <h2 className='text-center mt-4' style={{color:"red"}}> Welcome to Music Web page </h2>
        <div className='container mt-4 ' style={{"border":"2px solid Black"}}>
               <h3 className='text-center'> Music Data </h3>
                <table className='table table-bordered  table-hover'>
                    <thead>
                        <tr>
                              <th>Serial No.</th>
            <th>Song Name</th>
            <th>Song Duration</th>
            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            music.map((musicItem,index)=>{
                                return(<tr>
                                    <td>{index+1}</td>
                                    <td>{musicItem.songName}</td>
                                    <td>{musicItem.songDuration}</td>
                                    <td className='btn btn-danger' onClick={()=>{ondelete(musicItem.id)}}>Delete Song </td>
                                </tr>)
                            })
                        }
                    </tbody>
                </table>
               </div>
 {/* //----------------------------------- form  */}

<div>
    <div className='container mt-5'> 
    <h2 className='container text-center ' style={{color:"red"}}> Add New Music  here...</h2>
    <form className='form-control' style={{border:"2px solid black"}}>
        <div>
            <label className='form-label'>Enter Music Name : </label>
        <input type='text' placeholder='Ae dil hai muskil' onChange={(event)=>{formData(event,'songName')}}/>
        </div>
         <br></br>
           <div>
            <label className='form-label'>Enter Music Duration : </label>
        <input type='numnber' placeholder='5.34 or 33.21' onChange={(event)=>{formData(event,'songDuration')}}/>
        </div>
        <button className='btn btn-info' onClick={()=>onPost()}>Save </button>
    </form>
</div>
</div>

        </div>
    
  )
}

export default Music
import { useState } from "react";

function Main(){
let [page, setPage] = useState(1);
console.log('렌더링',page);
const leftBtnClick = ()=>{
	setPage(page == 1 ? 13 : page-1); //setPage를 이용하면 렌더링도 같이 일어나서 동시 확인 가능
}
const rightBtnClick = ()=>{
	setPage(page == 13 ? 1 : page+1);
}

  return(
    <main>
			<div>
				<button onClick={leftBtnClick}>-</button>
				<span>{page} / 13</span>
				<button onClick={rightBtnClick}>+</button>
			</div>
		</main>
  )
}

export default Main;
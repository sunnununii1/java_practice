import './css/Menu.css'

function Menu(){
  return(
    <nav>
      <ul className='menu-list'>
        <li className='menu-item'>
          <a className='menu-link' href="#">메뉴 1</a>
        </li>
        <li className='menu-item'>
          <a className='menu-link' href="#">메뉴 2</a>
        </li>
        <li className='menu-item'>
          <a className='menu-link' href="#">메뉴 3</a>
        </li>
      </ul>
    </nav>
  );
}

export default Menu;
import { NbMenuItem } from '@nebular/theme';

export const MENU_ITEMS: NbMenuItem[] = [

  {
    title: 'Equipment Management',
    icon: 'nb-keypad',
    link: '/pages/device/equipment-list',
    home: true,
  },
  {
    title: 'Alarm',
    icon: 'nb-alert',
    link: '/pages/alarm',
    home: true,
  },
  {
    title: 'User Management',
    icon: 'nb-person',
    link: '/pages/users/user-list',
    home: true,
  },
  {
    title: 'Auth',
    icon: 'nb-locked',
    children: [
      {
        title: 'Login',
        link: '/auth/login',
      },
      {
        title: 'Register',
        link: '/auth/register',
      },
      {
        title: 'Request Password',
        link: '/auth/request-password',
      },
      {
        title: 'Reset Password',
        link: '/auth/reset-password',
      },
    ],
  },

];

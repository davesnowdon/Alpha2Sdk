package com.ubtechinc.alpha2serverlib.aidlinterface;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IAlphaActionClient extends IInterface {
   void onActionStop(String var1) throws RemoteException;

   public abstract static class Stub extends Binder implements IAlphaActionClient {
      private static final String DESCRIPTOR = "com.ubtechinc.alpha2serverlib.aidlinterface.IAlphaActionClient";
      static final int TRANSACTION_onActionStop = 1;

      public Stub() {
         this.attachInterface(this, "com.ubtechinc.alpha2serverlib.aidlinterface.IAlphaActionClient");
      }

      public static IAlphaActionClient asInterface(IBinder obj) {
         if (obj == null) {
            return null;
         } else {
            IInterface iin = obj.queryLocalInterface("com.ubtechinc.alpha2serverlib.aidlinterface.IAlphaActionClient");
            return (IAlphaActionClient)(iin != null && iin instanceof IAlphaActionClient ? (IAlphaActionClient)iin : new IAlphaActionClient.Stub.Proxy(obj));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
         switch(code) {
         case 1:
            data.enforceInterface("com.ubtechinc.alpha2serverlib.aidlinterface.IAlphaActionClient");
            String _arg0 = data.readString();
            this.onActionStop(_arg0);
            reply.writeNoException();
            return true;
         case 1598968902:
            reply.writeString("com.ubtechinc.alpha2serverlib.aidlinterface.IAlphaActionClient");
            return true;
         default:
            return super.onTransact(code, data, reply, flags);
         }
      }

      private static class Proxy implements IAlphaActionClient {
         private IBinder mRemote;

         Proxy(IBinder remote) {
            this.mRemote = remote;
         }

         public IBinder asBinder() {
            return this.mRemote;
         }

         public String getInterfaceDescriptor() {
            return "com.ubtechinc.alpha2serverlib.aidlinterface.IAlphaActionClient";
         }

         public void onActionStop(String strActionFileName) throws RemoteException {
            Parcel _data = Parcel.obtain();
            Parcel _reply = Parcel.obtain();

            try {
               _data.writeInterfaceToken("com.ubtechinc.alpha2serverlib.aidlinterface.IAlphaActionClient");
               _data.writeString(strActionFileName);
               this.mRemote.transact(1, _data, _reply, 0);
               _reply.readException();
            } finally {
               _reply.recycle();
               _data.recycle();
            }

         }
      }
   }
}

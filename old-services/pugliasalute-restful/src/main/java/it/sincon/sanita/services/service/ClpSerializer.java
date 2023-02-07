package it.sincon.sanita.services.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import it.sincon.sanita.services.model.CFG_CategorieAbilitateClp;
import it.sincon.sanita.services.model.CategoriaStrutturaClp;
import it.sincon.sanita.services.model.NewsClp;
import it.sincon.sanita.services.model.StrutturaSanitariaClp;
import it.sincon.sanita.services.model.StrutturaSanitariaFigliaClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;


public class ClpSerializer {
    private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
    private static String _servletContextName;
    private static boolean _useReflectionToTranslateThrowable = true;

    public static String getServletContextName() {
        if (Validator.isNotNull(_servletContextName)) {
            return _servletContextName;
        }

        synchronized (ClpSerializer.class) {
            if (Validator.isNotNull(_servletContextName)) {
                return _servletContextName;
            }

            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Class<?> portletPropsClass = classLoader.loadClass(
                        "com.liferay.util.portlet.PortletProps");

                Method getMethod = portletPropsClass.getMethod("get",
                        new Class<?>[] { String.class });

                String portletPropsServletContextName = (String) getMethod.invoke(null,
                        "pugliasalute-restful-deployment-context");

                if (Validator.isNotNull(portletPropsServletContextName)) {
                    _servletContextName = portletPropsServletContextName;
                }
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info(
                        "Unable to locate deployment context from portlet properties");
                }
            }

            if (Validator.isNull(_servletContextName)) {
                try {
                    String propsUtilServletContextName = PropsUtil.get(
                            "pugliasalute-restful-deployment-context");

                    if (Validator.isNotNull(propsUtilServletContextName)) {
                        _servletContextName = propsUtilServletContextName;
                    }
                } catch (Throwable t) {
                    if (_log.isInfoEnabled()) {
                        _log.info(
                            "Unable to locate deployment context from portal properties");
                    }
                }
            }

            if (Validator.isNull(_servletContextName)) {
                _servletContextName = "pugliasalute-restful";
            }

            return _servletContextName;
        }
    }

    public static Object translateInput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(CategoriaStrutturaClp.class.getName())) {
            return translateInputCategoriaStruttura(oldModel);
        }

        if (oldModelClassName.equals(CFG_CategorieAbilitateClp.class.getName())) {
            return translateInputCFG_CategorieAbilitate(oldModel);
        }

        if (oldModelClassName.equals(NewsClp.class.getName())) {
            return translateInputNews(oldModel);
        }

        if (oldModelClassName.equals(StrutturaSanitariaClp.class.getName())) {
            return translateInputStrutturaSanitaria(oldModel);
        }

        if (oldModelClassName.equals(
                    StrutturaSanitariaFigliaClp.class.getName())) {
            return translateInputStrutturaSanitariaFiglia(oldModel);
        }

        return oldModel;
    }

    public static Object translateInput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateInput(curObj));
        }

        return newList;
    }

    public static Object translateInputCategoriaStruttura(BaseModel<?> oldModel) {
        CategoriaStrutturaClp oldClpModel = (CategoriaStrutturaClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getCategoriaStrutturaRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputCFG_CategorieAbilitate(
        BaseModel<?> oldModel) {
        CFG_CategorieAbilitateClp oldClpModel = (CFG_CategorieAbilitateClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getCFG_CategorieAbilitateRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputNews(BaseModel<?> oldModel) {
        NewsClp oldClpModel = (NewsClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getNewsRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputStrutturaSanitaria(BaseModel<?> oldModel) {
        StrutturaSanitariaClp oldClpModel = (StrutturaSanitariaClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getStrutturaSanitariaRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputStrutturaSanitariaFiglia(
        BaseModel<?> oldModel) {
        StrutturaSanitariaFigliaClp oldClpModel = (StrutturaSanitariaFigliaClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getStrutturaSanitariaFigliaRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateInput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateInput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Object translateOutput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(
                    "it.sincon.sanita.services.model.impl.CategoriaStrutturaImpl")) {
            return translateOutputCategoriaStruttura(oldModel);
        }

        if (oldModelClassName.equals(
                    "it.sincon.sanita.services.model.impl.CFG_CategorieAbilitateImpl")) {
            return translateOutputCFG_CategorieAbilitate(oldModel);
        }

        if (oldModelClassName.equals(
                    "it.sincon.sanita.services.model.impl.NewsImpl")) {
            return translateOutputNews(oldModel);
        }

        if (oldModelClassName.equals(
                    "it.sincon.sanita.services.model.impl.StrutturaSanitariaImpl")) {
            return translateOutputStrutturaSanitaria(oldModel);
        }

        if (oldModelClassName.equals(
                    "it.sincon.sanita.services.model.impl.StrutturaSanitariaFigliaImpl")) {
            return translateOutputStrutturaSanitariaFiglia(oldModel);
        }

        return oldModel;
    }

    public static Object translateOutput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateOutput(curObj));
        }

        return newList;
    }

    public static Object translateOutput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateOutput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateOutput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Throwable translateThrowable(Throwable throwable) {
        if (_useReflectionToTranslateThrowable) {
            try {
                UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

                objectOutputStream.writeObject(throwable);

                objectOutputStream.flush();
                objectOutputStream.close();

                UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
                        0, unsyncByteArrayOutputStream.size());

                Thread currentThread = Thread.currentThread();

                ClassLoader contextClassLoader = currentThread.getContextClassLoader();

                ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
                        contextClassLoader);

                throwable = (Throwable) objectInputStream.readObject();

                objectInputStream.close();

                return throwable;
            } catch (SecurityException se) {
                if (_log.isInfoEnabled()) {
                    _log.info("Do not use reflection to translate throwable");
                }

                _useReflectionToTranslateThrowable = false;
            } catch (Throwable throwable2) {
                _log.error(throwable2, throwable2);

                return throwable2;
            }
        }

        Class<?> clazz = throwable.getClass();

        String className = clazz.getName();

        if (className.equals(PortalException.class.getName())) {
            return new PortalException();
        }

        if (className.equals(SystemException.class.getName())) {
            return new SystemException();
        }

        if (className.equals(
                    "it.sincon.sanita.services.NoSuchCategoriaStrutturaException")) {
            return new it.sincon.sanita.services.NoSuchCategoriaStrutturaException();
        }

        if (className.equals(
                    "it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException")) {
            return new it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException();
        }

        if (className.equals("it.sincon.sanita.services.NoSuchNewsException")) {
            return new it.sincon.sanita.services.NoSuchNewsException();
        }

        if (className.equals(
                    "it.sincon.sanita.services.NoSuchStrutturaSanitariaException")) {
            return new it.sincon.sanita.services.NoSuchStrutturaSanitariaException();
        }

        if (className.equals(
                    "it.sincon.sanita.services.NoSuchStrutturaSanitariaFigliaException")) {
            return new it.sincon.sanita.services.NoSuchStrutturaSanitariaFigliaException();
        }

        return throwable;
    }

    public static Object translateOutputCategoriaStruttura(
        BaseModel<?> oldModel) {
        CategoriaStrutturaClp newModel = new CategoriaStrutturaClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setCategoriaStrutturaRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputCFG_CategorieAbilitate(
        BaseModel<?> oldModel) {
        CFG_CategorieAbilitateClp newModel = new CFG_CategorieAbilitateClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setCFG_CategorieAbilitateRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputNews(BaseModel<?> oldModel) {
        NewsClp newModel = new NewsClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setNewsRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputStrutturaSanitaria(
        BaseModel<?> oldModel) {
        StrutturaSanitariaClp newModel = new StrutturaSanitariaClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setStrutturaSanitariaRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputStrutturaSanitariaFiglia(
        BaseModel<?> oldModel) {
        StrutturaSanitariaFigliaClp newModel = new StrutturaSanitariaFigliaClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setStrutturaSanitariaFigliaRemoteModel(oldModel);

        return newModel;
    }
}
